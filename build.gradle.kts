// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}
plugins {

    alias(libs.plugins.android.application) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.11" apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}