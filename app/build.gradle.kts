import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kspAndroid)
    alias(libs.plugins.kaptKotlin)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.daggerHilt)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}


val apiKeysProperties = Properties().apply {
    val apiKeysFileStream = rootProject.file("apikey.properties").inputStream()
    load(apiKeysFileStream)
    apiKeysFileStream.close()
}

android {
    namespace = "com.ibrahim.myrecipes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ibrahim.myrecipes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }


    }

    kapt {
        arguments {
            arg("room.schemaLocation", projectDir.resolve("schemas").absolutePath)
            arg("room.incremental", "true")
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file(apiKeysProperties.getProperty("JKS_STORE_FILE") ?: "")
            storePassword = apiKeysProperties.getProperty("JKS_STORE_PASSWORD")
            keyAlias = apiKeysProperties.getProperty("JKS_KEY_ALIAS")
            keyPassword = apiKeysProperties.getProperty("JKS_KEY_PASSWORD")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.android.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.firebase.crashlytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltNavigation)
    implementation(libs.hiltWork)
    implementation(libs.androidWork)
    implementation(libs.androidAppcompat)

    implementation(libs.lottie)
    implementation(libs.roomruntime)
    implementation(libs.roomktx)
    ksp(libs.kspRoomCompiler)
    annotationProcessor(libs.kspRoomCompiler)
    implementation(libs.navigation)
    implementation(libs.coil)
    implementation(libs.composeConstraint)
    implementation(libs.admob)
    implementation(libs.viewbinding)
    implementation(libs.datastore)
}

kapt {
    correctErrorTypes = true
}
ksp {
    java {
        version = "17"
    }
}