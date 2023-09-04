plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.Android.application).version(Plugins.Gradle.version).apply(false)
    id(Plugins.Android.library).version(Plugins.Gradle.version).apply(false)
    kotlin(Plugins.Kotlin.android).version(Plugins.Kotlin.version).apply(false)
    kotlin(Plugins.Kotlin.multiplatform).version(Plugins.Kotlin.version).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
