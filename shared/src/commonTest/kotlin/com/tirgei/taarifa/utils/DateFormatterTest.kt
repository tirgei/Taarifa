package com.tirgei.taarifa.utils

import com.tirgei.taarifa.core.DateFormatter
import kotlin.test.Test
import kotlin.test.assertEquals

class DateFormatterTest {
    private val formatter = DateFormatter()
    private val inputDate = "2023-09-05T18:10:04Z"

    @Test
    fun `should return the correct date given the output format dd mm yy`() {
        val result = formatter.formatDate(inputDate, "dd/mm/yy")
        assertEquals("05/09/23", result)
    }

    @Test
    fun `should return the correct date given the output format dd mm yyyy`() {
        val result = formatter.formatDate(inputDate, "dd/mm/yyyy")
        assertEquals("05/09/2023", result)
    }

    @Test
    fun `should return the correct date given the output format dd MMM yyyy`() {
        val result = formatter.formatDate(inputDate, "dd MMM yyy")
        assertEquals("05 Sep 2023", result)
    }

}