package com.tirgei.taarifa.core

/**
 * Class to format handle various date formatting
 */
expect class DateFormatter() {

    /**
     * Function to format date from iso8601 format to expected format
     *
     * @param iso8601Timestamp - Date in iso8601 format e.g 2023-09-05T18:10:04Z
     * @param format - Expected output format e.g dd MMM
     * @return formatted date
     */
    fun formatDate(
        iso8601Timestamp: String,
        format: String
    ): String
}