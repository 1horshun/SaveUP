package com.horshun.core.domain.use_case

import com.horshun.core.domain.utils.UserState
import kotlinx.coroutines.flow.Flow

interface SplashUseCase {
    fun readAppStatus(): Flow<UserState>
}