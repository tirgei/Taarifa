object Plugins {

    object Versions {
        val gradle = "8.1.1"
        val kotlin = "1.9.10"
        val kmpNativeCoroutines = "1.0.0-ALPHA-18"
    }

    object Android {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "android"
        const val multiplatform = "multiplatform"
        const val kapt = "kotlin-kapt"
        val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        val serialization = "plugin.serialization"
    }

    object BuildKonfig {
        const val buildKonfig = "com.codingfeline.buildkonfig"
        val gradlePlugin = "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Libs.Lib.BUILD_KONFIG.version}"
    }

    object SqlDelight {
        val sqlDelight = "app.cash.sqldelight"
        val gradlePlugin = "app.cash.sqldelight:gradle-plugin:${Libs.Lib.SQL_DELIGHT.version}"
    }

    object Kotest {
        val multiplatform = "io.kotest.multiplatform"
    }

    object KMPNativeCoroutines {
        val nativeCoroutines = "com.rickclephas.kmp.nativecoroutines"
    }
}