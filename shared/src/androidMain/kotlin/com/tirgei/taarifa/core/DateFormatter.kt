package com.tirgei.taarifa.core

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

actual class DateFormatter {
    actual fun formatDate(
        iso8601Timestamp: String,
        format: String
    ): String {
        val date = getDateFromIso8601Timestamp(iso8601Timestamp)
        val formatter = DateTimeFormatter.ofPattern(format)
        return date.format(formatter)
    }

    private fun getDateFromIso8601Timestamp(string: String): ZonedDateTime {
        return ZonedDateTime.parse(string)
    }
}