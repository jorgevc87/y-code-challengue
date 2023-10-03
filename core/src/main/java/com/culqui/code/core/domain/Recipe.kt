package com.culqui.code.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Int,
    val title: String,
    val img: String,
    val desc: String,
    val coords: RecipeCoords?
) : Parcelable