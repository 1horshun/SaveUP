package com.horshun.core.domain.use_case

import kotlinx.coroutines.CoroutineScope

interface EditNameUseCase {
    fun editUsername(name: String, coroutineScope: CoroutineScope)
}