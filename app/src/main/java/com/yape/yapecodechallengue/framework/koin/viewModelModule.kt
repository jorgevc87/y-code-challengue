package com.yape.yapecodechallengue.framework.koin

import com.yape.yapecodechallengue.presentation.viewmodel.RecipeViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { RecipeViewModel(get()) }
}