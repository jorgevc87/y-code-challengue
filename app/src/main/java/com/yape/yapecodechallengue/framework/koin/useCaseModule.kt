package com.yape.yapecodechallengue.framework.koin

import com.culqui.code.core.interactor.Recipes
import org.koin.dsl.module

val useCaseModule = module{
    single { Recipes(get()) }
}