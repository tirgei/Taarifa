object Libs {

    enum class Lib(val version: String) {
        // Compose
        COMPOSE("1.4.3"),
        MATERIAL_3("1.1.1"),
        COMPOSE_NAVIGATION("2.7.1"),
        LIFECYCLE_RUNTIME("2.6.0-beta01"),

        // Coil
        COIL("2.4.0"),

        // Koin
        KOIN("3.2.0"),

        // Coroutines
        COROUTINES("1.6.4"),

        // Network
        KTOR("2.3.4"),
        KOTLIN_DATE_TIME("0.4.1"),

        // BuildKonfig
        BUILD_KONFIG("0.14.0"),

        // Logging
        NAPIER("2.6.1"),

        // Kotest
        KOTEST("5.7.1"),
    }

    object AndroidX {
        object Activity {
            val activity = "androidx.activity:activity-compose:1.7.1"
            val lifecyRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Lib.LIFECYCLE_RUNTIME.version}"
        }

        object Compose {
            val ui = "androidx.compose.ui:ui:${Lib.COMPOSE.version}"
            val uiTooling = "androidx.compose.ui:ui-tooling:${Lib.COMPOSE.version}"
            val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Lib.COMPOSE.version}"
            val foundation = "androidx.compose.foundation:foundation:${Lib.COMPOSE.version}"
            val material = "androidx.compose.material3:material3:${Lib.MATERIAL_3.version}"
            val googleFonts = "androidx.compose.ui:ui-text-google-fonts:${Lib.COMPOSE.version}"
            val navigation = "androidx.navigation:navigation-compose:${Lib.COMPOSE_NAVIGATION.version}"
        }

        object Coroutines {
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Lib.COROUTINES.version}"
        }
    }

    object DI {
        object Koin {
            val core = "io.insert-koin:koin-core:${Lib.KOIN.version}"
            val test = "io.insert-koin:koin-test:${Lib.KOIN.version}"
            val android = "io.insert-koin:koin-android:${Lib.KOIN.version}"
            val compose = "io.insert-koin:koin-androidx-compose:${Lib.KOIN.version}"
        }
    }

    object Images {
        object Coil {
            val coil = "io.coil-kt:coil-compose:${Lib.COIL.version}"
        }
    }

    object Network {
        object Ktor {
            val core = "io.ktor:ktor-client-core:${Lib.KTOR.version}"
            val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Lib.KTOR.version}"
            val serialization = "io.ktor:ktor-serialization-kotlinx-json:${Lib.KTOR.version}"

            object Android {
                val client = "io.ktor:ktor-client-android:${Lib.KTOR.version}"
            }

            object iOS {
                val client = "io.ktor:ktor-client-darwin:${Lib.KTOR.version}"
            }
        }

        val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Lib.KOTLIN_DATE_TIME.version}"
    }

    object Logging {
        val napier = "io.github.aakira:napier:${Lib.NAPIER.version}"
    }

    object Test {
        object Kotest {
            val core = "io.kotest:kotest-framework-engine:${Lib.KOTEST.version}"
            val assertions = "io.kotest:kotest-assertions-core:${Lib.KOTEST.version}"
        }
    }
}