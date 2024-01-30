// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.daggerHilt) apply false
    alias(libs.plugins.kspAndroid) apply false
    alias(libs.plugins.kaptKotlin) apply false
    alias(libs.plugins.kotlinParcelize) apply false
}
true