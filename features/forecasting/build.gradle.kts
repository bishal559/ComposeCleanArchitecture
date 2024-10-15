import com.androidx.buildsrc.JavaCompatibilityVersion


plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.gradle.plugin)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
}

android {
    namespace = "com.bishal.forecasting"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.get()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.life.cycle.view.model)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)


    implementation(libs.coil.compose)
    implementation(libs.androidx.androidx.navigation)

    implementation(libs.hilt.navigation.compose)


    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(project(Module.DATA))
    implementation(project(Module.CORE_UI))
}