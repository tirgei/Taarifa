object Plugins {
    object Gradle {
        const val version = "8.1.1"
    }

    object Android {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val version = "1.8.21"
        const val android = "android"
        const val multiplatform = "multiplatform"
        const val kapt = "kotlin-kapt"
        val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Dagger {
        const val hilt = "com.google.dagger.hilt.android"
        val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Libs.Lib.DAGGER_HILT.version}"
    }
}