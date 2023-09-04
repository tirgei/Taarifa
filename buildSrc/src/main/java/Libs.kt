object Libs {

    enum class Lib(val version: String) {
        // Compose
        COMPOSE("1.4.3"),
        MATERIAL_3("1.1.1"),

        // Dagger Hilt
        DAGGER_HILT("2.42"),
        HILT_NAVIGATION("1.0.0")
    }

    object AndroidX {
        object Activity {
            val activity = "androidx.activity:activity-compose:1.7.1"
        }

        object Compose {
            val ui = "androidx.compose.ui:ui:${Lib.COMPOSE.version}"
            val uiTooling = "androidx.compose.ui:ui-tooling:${Lib.COMPOSE.version}"
            val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Lib.COMPOSE.version}"
            val foundation = "androidx.compose.foundation:foundation:${Lib.COMPOSE.version}"
            val material = "androidx.compose.material3:material3:${Lib.MATERIAL_3.version}"
            val googleFonts = "androidx.compose.ui:ui-text-google-fonts:${Lib.COMPOSE.version}"
        }
    }

    object DI {
        object Dagger {
            val hilt = "com.google.dagger:hilt-android:${Lib.DAGGER_HILT.version}"
            val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Lib.DAGGER_HILT.version}"
            val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Lib.HILT_NAVIGATION.version}"
        }
    }
}