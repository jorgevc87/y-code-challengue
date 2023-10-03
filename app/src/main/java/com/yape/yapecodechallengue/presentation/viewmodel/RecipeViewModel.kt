package com.yape.yapecodechallengue.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.culqui.code.core.domain.Recipe
import com.culqui.code.core.interactor.Recipes
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipeViewModel(private val recipes: Recipes) : BaseViewModel() {

    val getReceipesResult = MutableLiveData<List<Recipe>?>()

    fun getRecipes() {
        viewModelScope.launch {
            try {
                val result = recipes.getRecipes()

                getReceipesResult.postValue(result)
            } catch (ex: Exception) {
                Log.i("JORGEVC", "Error: ${ex.localizedMessage}")
            }
        }
    }
}