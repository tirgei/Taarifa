package com.tirgei.taarifa.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionsTest {

    @Test
    fun `should format date to dd MMM yyyy format`() {
        val result = "2023-09-05T18:10:04Z".formatToDate("dd MMM yyyy")
        assertEquals("05 Sep 2023", result)
    }

    @Test
    fun `should format date to dd MM yyyy format`() {
        val result = "2023-09-05T18:10:04Z".formatToDate("dd MM yyyy")
        assertEquals("05 09 2023", result)
    }

}