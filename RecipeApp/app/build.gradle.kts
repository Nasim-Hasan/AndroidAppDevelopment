plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.counterappmvvmrepository"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.counterappmvvmrepository"
        minSdk = 24
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
    //Navigation purpose
    implementation(libs.androidx.navigation.compose)
    //Compose ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    //Network calls
    implementation(libs.retrofit)
    //Json to Kotlin object mapping
    implementation(libs.converter.gson)
    //Image loading
    implementation(libs.coil.compose)
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.activity.compose.v1122)
    implementation(platform(libs.androidx.compose.bom.v20230800))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v130)
    androidTestImplementation(libs.androidx.espresso.core.v370)
    androidTestImplementation(libs.androidx.compose.bom.v20260100)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation ("androidx.compose.ui:ui:1.0.5") // Example version
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.21")
}