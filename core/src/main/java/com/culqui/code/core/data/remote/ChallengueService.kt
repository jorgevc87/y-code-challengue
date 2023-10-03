package com.culqui.code.core.data.remote

import com.culqui.code.core.data.remote.dto.RecipeDto
import retrofit2.Response
import retrofit2.http.POST

interface ChallengueService {

    @POST("/get-recipes")
    suspend fun getRecipes(): Response<ResponseDto<List<RecipeDto>?>>

}