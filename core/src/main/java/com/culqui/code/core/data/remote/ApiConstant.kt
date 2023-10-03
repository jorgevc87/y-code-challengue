package com.culqui.code.core.data.remote

import com.culqui.code.core.BuildConfig

class ApiConstant {

    companion object {
        const val BASE_URL = BuildConfig.API_URL
        const val API_TIME_OUT: Long = 6000
    }

}