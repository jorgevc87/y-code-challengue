package com.culqui.code.core.data.repository

import com.culqui.code.core.data.remote.ApiResponse
import com.culqui.code.core.data.remote.ResponseDto
import com.culqui.code.core.data.remote.dto.RecipeDto

interface RecipeRepository {

    suspend fun getRecipes() : ApiResponse<ResponseDto<List<RecipeDto>?>>

}