@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    kotlin("android")
    kotlin("kapt")
    alias(libs.plugins.navigationSafeArgs)
    id("samples.materialmotion.spotless")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "dev.sergiobelda.samples.materialmotion"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    namespace = "dev.sergiobelda.samples.materialmotion"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.coreKtx)
    implementation(libs.androidx.navigation.navigationFragmentKtx)
    implementation(libs.androidx.navigation.navigationUiKtx)
    implementation(libs.androidx.paletteKtx)
    implementation(libs.google.material)
    implementation(libs.glide)
    kapt(libs.glide.compiler)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    testImplementation(libs.junit)
}
