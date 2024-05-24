plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization") version "1.9.21"
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.swethaassignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.swethaassignment"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    /*
   Room Database
    */
    //noinspection GradleDependency
    implementation(libs.androidx.room.runtime)
    //noinspection GradleDependency
    ksp(libs.androidx.room.compiler)
//    implementation("androidx.room:room-coroutines:2.1.0-alpha04")
    // Kotlin Extensions and Coroutines support for Room
    //noinspection GradleDependency
    implementation(libs.androidx.room.ktx)
    //noinspection GradleDependency


    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.okhttp)

    implementation(libs.androidx.core.splashscreen)
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    /*
   Hilt
    */

    implementation(libs.hilt.android)
    ksp(libs.dagger.compiler) // Dagger compiler
    ksp(libs.hilt.compiler)
    // Hilt compiler
    /*
   navigation
    */
    implementation(libs.androidx.hilt.navigation.compose)
    implementation("io.coil-kt:coil-compose:2.5.0")



    implementation("androidx.paging:paging-common:3.3.0")
    implementation("androidx.paging:paging-runtime:3.3.0")
    implementation("androidx.paging:paging-compose:3.3.0")

}