plugins {
    id(Plugins.Android.application)
    kotlin(Plugins.Kotlin.android)
}

android {
    namespace = "${Config.Android.id}.android"
    compileSdk = 33
    defaultConfig {
        applicationId = Config.Android.id
        minSdk = Config.Android.minSdk
        targetSdk = Config.Android.targetSdk
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName(Config.BuildTypes.release) {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Compose.uiToolingPreview)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Activity.activity)
}