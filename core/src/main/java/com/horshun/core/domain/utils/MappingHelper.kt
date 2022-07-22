package com.horshun.core.domain.utils

import com.horshun.core.data.source.local.database.entity.ActivityEntity
import com.horshun.core.domain.models.ActivityDomain

fun ActivityEntity.mapToDomain(): ActivityDomain {
    return with(this) {
        ActivityDomain(id, name, amount, date, isExpense)
    }
}

fun ActivityDomain.mapToEntity(): ActivityEntity {
    return with(this) {
        ActivityEntity(id, name, amount, date, isExpense)
    }
}

