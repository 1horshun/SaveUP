package com.horshun.saveup.utils

import java.text.NumberFormat
import java.util.*

internal fun Long?.toCurrencyFormat(): String {
    return NumberFormat.getCurrencyInstance(Locale("ms", "MY")).format(this) ?: "0"
}