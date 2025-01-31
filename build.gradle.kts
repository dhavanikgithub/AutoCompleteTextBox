// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val hiltVersion by extra("2.46.1")
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}