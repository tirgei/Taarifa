object Libs {

    enum class Lib(val version: String) {
        COMPOSE("1.4.3")
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
            val material = "androidx.compose.material:material:${Lib.COMPOSE.version}"
        }
    }
}