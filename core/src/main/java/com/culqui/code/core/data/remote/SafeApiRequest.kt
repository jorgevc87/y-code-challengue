package com.culqui.code.core.data.remote

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): ApiResponse<T> {
        if (!isNetworkAvailable1()) return ApiResponse.error(111, "Sin conexión a internet", null)
        val response = call.invoke()
        if (response.isSuccessful) return ApiResponse.success(
            response.code(),
            response.body()
        ) else {

            return try {
                val gson = Gson()
                val type = object : TypeToken<ApiResponse<String>>() {}.type
                val error: ApiResponse<String>? =
                    gson.fromJson(response.errorBody()!!.charStream(), type)

                error?.let {
                    ApiResponse.error(
                        response.code(),
                        it.message ?: "Error Inesperado",
                        response.body()
                    )
                }!!
            } catch (e: Exception) {
                ApiResponse.error(response.code(), e.toString(), response.body())
            }
        }
    }

    fun isNetworkAvailable1(): Boolean {
        val runtime = Runtime.getRuntime()
        try {
            val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
            val exitValue = ipProcess.waitFor()
            return exitValue == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }
}
