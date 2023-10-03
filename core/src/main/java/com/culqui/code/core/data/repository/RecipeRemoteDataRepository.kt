package com.culqui.code.core.data.repository

import com.culqui.code.core.data.remote.ApiResponse
import com.culqui.code.core.data.remote.ChallengueService
import com.culqui.code.core.data.remote.ResponseDto
import com.culqui.code.core.data.remote.dto.RecipeDto
import org.koin.core.component.inject

class RecipeRemoteDataRepository : BaseRepository(), RecipeRepository {

    private val apiService: ChallengueService by inject()

    override suspend fun getRecipes(): ApiResponse<ResponseDto<List<RecipeDto>?>> {
        return apiRequest {
            apiService.getRecipes()
        }
    }
}