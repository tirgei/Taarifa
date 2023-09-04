plugins {
    id(Plugins.Android.application)
    kotlin(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Dagger.hilt)

}

android {
    namespace = Config.Android.id
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))

    // AndroidX
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Compose.uiToolingPreview)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.googleFonts)
    implementation(Libs.AndroidX.Activity.activity)

    // DI
    implementation(Libs.DI.Dagger.hilt)
    implementation(Libs.DI.Dagger.hiltNavigation)
    kapt(Libs.DI.Dagger.hiltAndroidCompiler)

}

