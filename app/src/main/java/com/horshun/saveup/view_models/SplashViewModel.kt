package com.horshun.saveup.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.horshun.core.domain.use_case.SplashUseCase
import com.horshun.core.domain.utils.UserState

class SplashViewModel(private val splashUseCase: SplashUseCase): ViewModel() {
    fun readOnBoardingState(): LiveData<UserState> = splashUseCase.readAppStatus().asLiveData()
}