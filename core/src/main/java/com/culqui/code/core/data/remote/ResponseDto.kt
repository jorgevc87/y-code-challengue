package com.culqui.code.core.data.remote

import com.google.gson.annotations.SerializedName

data class ResponseDto<T>(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: T,
    @SerializedName("message") val message: String
)