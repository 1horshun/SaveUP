package com.horshun.core.domain.use_case

import com.horshun.core.domain.models.ActivityDomain
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    fun readUserName(): Flow<String>
    fun readSumExpenses(): Flow<Long>
    fun readSumIncome(): Flow<Long>
    fun getAllActivityData(): Flow<List<ActivityDomain>>
}