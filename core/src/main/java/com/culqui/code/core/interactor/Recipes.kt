package com.culqui.code.core.interactor

import com.culqui.code.core.data.remote.ApiStatus
import com.culqui.code.core.data.remote.dto.RecipeCoordsDto
import com.culqui.code.core.data.remote.dto.RecipeDto
import com.culqui.code.core.data.repository.RecipeRemoteDataRepository
import com.culqui.code.core.domain.Recipe
import com.culqui.code.core.domain.RecipeCoords

class Recipes(val recipeRemoteDataRepository: RecipeRemoteDataRepository) {

    suspend fun getRecipes(): List<Recipe>? {
        val result = recipeRemoteDataRepository.getRecipes()

        return if (result.status == ApiStatus.SUCCESS) {
            result.data?.let { d ->
                mapperList(d.data)
            }
        } else {
            null
        }
    }

    private fun mapper(param: RecipeDto?): Recipe? {
        return param?.let {
            Recipe(it.id, it.title, it.img, it.desc, mapperCoords(it.coords))
        } ?: run {
            null
        }
    }

    private fun mapperCoords(param: RecipeCoordsDto?): RecipeCoords? {
        return param?.let {
            RecipeCoords(it.latitud, it.longitud)
        } ?: run {
            null
        }
    }

    private fun mapperList(param: List<RecipeDto>?): List<Recipe>? {
        return param?.let { l ->
            val output = ArrayList<Recipe>()

            l.forEach {
                mapper(it)?.let { it1 ->
                    output.add(it1)
                }
            }

            output
        } ?: run {
            null
        }
    }

}