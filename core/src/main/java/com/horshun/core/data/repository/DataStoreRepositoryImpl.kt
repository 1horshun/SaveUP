package com.horshun.core.data.repository

import com.horshun.core.data.source.local.data_store.IDataStoreSource
import com.horshun.core.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class DataStoreRepositoryImpl(private val dataStoreSource: IDataStoreSource) : DataStoreRepository {
    override suspend fun saveOnBoardingStateToDataStore(state: Boolean) =
        dataStoreSource.saveOnBoardingState(state)

    override fun readOnBoardingStateFromDataStore(): Flow<Boolean> =
        dataStoreSource.readOnBoardingState()

    override suspend fun saveNameUserToDataStore(name: String) {
        dataStoreSource.saveNameUser(name)
    }

    override fun readNameUserFromDataStore(): Flow<String> = dataStoreSource.readNameUser()

    override suspend fun saveNotificationToDataStore(state: Boolean) {
        dataStoreSource.saveNotificationState(state)
    }

    override fun readNotificationFromDataStore(): Flow<Boolean> =
        dataStoreSource.readNotificationState()
}