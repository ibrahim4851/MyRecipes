plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kspAndroid)
    alias(libs.plugins.kaptKotlin)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.daggerHilt)
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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

kapt {
    correctErrorTypes = true
}
ksp {
    java {
        version = "17"
    }
}