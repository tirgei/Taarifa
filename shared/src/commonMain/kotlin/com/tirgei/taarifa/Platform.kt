package com.tirgei.taarifa

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform