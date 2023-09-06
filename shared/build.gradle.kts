import java.util.Properties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin(Plugins.Kotlin.multiplatform)
    id(Plugins.Android.library)
    kotlin(Plugins.Kotlin.serialization) version Plugins.Versions.kotlin
    id(Plugins.BuildKonfig.buildKonfig)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(Libs.AndroidX.Coroutines.core)

                // DI
                implementation(Libs.DI.Koin.core)
                implementation(Libs.DI.Koin.test)

                // Network
                implementation(Libs.Network.Ktor.core)
                implementation(Libs.Network.Ktor.contentNegotiation)
                implementation(Libs.Network.Ktor.serialization)
                implementation(Libs.Network.dateTime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Libs.Network.Ktor.Android.client)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(Libs.Network.Ktor.iOS.client)
            }
        }
    }
}

android {
    namespace = Config.Android.id
    compileSdk = Config.Android.compileSdk
    defaultConfig {
        minSdk = Config.Android.minSdk
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

buildkonfig {
    packageName = Config.Android.id

    defaultConfigs {
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField(STRING, "BASE_URL", "${properties.getProperty("NEWS_BASE_URL")}")
        buildConfigField(STRING, "API_KEY", "${properties.getProperty("NEWS_API_KEY")}")
    }
}