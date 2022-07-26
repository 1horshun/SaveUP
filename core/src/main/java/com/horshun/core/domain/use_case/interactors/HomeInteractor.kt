package com.horshun.core.domain.use_case.interactors

import com.horshun.core.domain.models.ActivityDomain
import com.horshun.core.domain.repository.ActivityRepository
import com.horshun.core.domain.repository.DataStoreRepository
import com.horshun.core.domain.use_case.HomeUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow

class HomeInteractor(
    private val dataStoreRepository: DataStoreRepository,
    private val activityRepository: ActivityRepository
) : HomeUseCase {
    override fun readUserName(): Flow<String> = dataStoreRepository.readNameUserFromDataStore()

    override fun readSumExpenses(): Flow<Long> = flow {
        activityRepository.getSumExpensesData().filterNotNull().collect {
            emit(it)
        }
    }

    override fun readSumIncome(): Flow<Long> = flow {
        activityRepository.getSumIncomeData().filterNotNull().collect {
            emit(it)
        }
    }

    override fun getAllActivityData(): Flow<List<ActivityDomain>> =
        activityRepository.getAllActivityData()
}