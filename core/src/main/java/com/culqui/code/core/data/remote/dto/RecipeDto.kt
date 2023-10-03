package com.culqui.code.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("img") val img: String,
    @SerializedName("desc") val desc: String,
    @SerializedName("coords") val coords: RecipeCoordsDto
)