package com.horshun.core.domain.utils

sealed class UserState {
    object OnBoarding: UserState()
    object Welcome: UserState()
    object Menu: UserState()
}