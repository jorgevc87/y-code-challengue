package com.yape.yapecodechallengue.framework

import android.app.Application
import com.yape.yapecodechallengue.framework.koin.apiModule
import com.yape.yapecodechallengue.framework.koin.respositoryModule
import com.yape.yapecodechallengue.framework.koin.useCaseModule
import com.yape.yapecodechallengue.framework.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class CodeChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CodeChallengeApplication)
            modules(getModule())
        }
    }

    private fun getModule(): List<Module> {
        return listOf(
            apiModule,
            respositoryModule,
            useCaseModule,
            viewModelModule
        )
    }

}