package com.horshun.core.domain.use_case

import kotlinx.coroutines.CoroutineScope

interface OnBoardingUseCase {
    fun saveState(state: Boolean, coroutineScope: CoroutineScope)
    fun saveUserName(name: String, coroutineScope: CoroutineScope)
}

