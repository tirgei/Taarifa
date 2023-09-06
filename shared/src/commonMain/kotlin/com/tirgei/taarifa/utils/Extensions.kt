package com.tirgei.taarifa.utils

import com.tirgei.taarifa.core.DateFormatter

/**
 * Formats date to the provided output format
 * @param format - Expected date format
 */
fun String?.formatToDate(format: String): String? {
    return this?.let { input ->
        DateFormatter().formatDate(input, format)
    }
}