package com.yape.yapecodechallengue.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {

    val loadingStatus = MutableLiveData<Boolean>()

    val errorResult = MutableLiveData<Error>()

}