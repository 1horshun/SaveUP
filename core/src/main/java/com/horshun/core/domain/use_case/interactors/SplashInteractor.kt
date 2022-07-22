package com.horshun.core.domain.use_case.interactors

import com.horshun.core.domain.repository.DataStoreRepository
import com.horshun.core.domain.use_case.SplashUseCase
import com.horshun.core.domain.utils.UserState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class SplashInteractor(private val dataStoreRepository: DataStoreRepository) : SplashUseCase {
    override fun readAppStatus(): Flow<UserState> = flow {
        val onBoardingStatus = dataStoreRepository.readOnBoardingStateFromDataStore().first()
        val nameUserStatus = dataStoreRepository.readNameUserFromDataStore().first()

        if (onBoardingStatus && nameUserStatus.isNotBlank()) {
            emit(UserState.Menu)
        } else if (onBoardingStatus && nameUserStatus.isBlank()) {
            emit(UserState.Welcome)
        } else {
            emit(UserState.OnBoarding)
        }
    }
}