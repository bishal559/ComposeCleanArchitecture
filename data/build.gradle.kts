import com.androidx.buildsrc.JavaCompatibilityVersion

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.gradle.plugin)
    kotlin("kapt")

}

android {
    namespace = "com.bishal.data"
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfig.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    compileOptions {
        sourceCompatibility = JavaCompatibilityVersion.sourceCompatibility
        targetCompatibility = JavaCompatibilityVersion.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = JavaCompatibilityVersion.JVM_TARGET
    }
}

dependencies {

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Retrofit
    implementation(libs.ok.https)
    implementation(libs.ok.https.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi.converter)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.gson)
}