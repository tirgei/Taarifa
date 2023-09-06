object Plugins {

    object Versions {
        val gradle = "8.1.1"
        val kotlin = "1.8.21"
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
}