package com.culqui.code.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RecipeCoordsDto(
    @SerializedName("lat") val latitud: String,
    @SerializedName("lng") val longitud: String
)