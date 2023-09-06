buildscript {
    dependencies {
        classpath(Plugins.Kotlin.gradlePlugin)
        classpath(Plugins.BuildKonfig.gradlePlugin)
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.Android.application).version(Plugins.Versions.gradle).apply(false)
    id(Plugins.Android.library).version(Plugins.Versions.gradle).apply(false)
    kotlin(Plugins.Kotlin.android).version(Plugins.Versions.kotlin).apply(false)
    kotlin(Plugins.Kotlin.multiplatform).version(Plugins.Versions.kotlin).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
