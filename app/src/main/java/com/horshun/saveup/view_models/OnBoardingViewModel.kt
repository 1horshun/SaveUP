package com.horshun.saveup.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horshun.core.domain.use_case.OnBoardingUseCase

class OnBoardingViewModel(private val onBoardingUseCase: OnBoardingUseCase): ViewModel() {
    fun saveState(state: Boolean) = onBoardingUseCase.saveState(state, viewModelScope)
    fun saveUserName(name: String) = onBoardingUseCase.saveUserName(name, viewModelScope)
}

