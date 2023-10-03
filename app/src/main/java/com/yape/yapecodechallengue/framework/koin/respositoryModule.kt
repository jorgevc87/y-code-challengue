package com.yape.yapecodechallengue.framework.koin

import com.culqui.code.core.data.repository.RecipeRemoteDataRepository
import org.koin.dsl.module

val respositoryModule = module {
    single { RecipeRemoteDataRepository() }
}