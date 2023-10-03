package com.culqui.code.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeCoords(val lat: String, val lng: String) : Parcelable