plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.refine)
}

android {
    namespace = "io.github.chsbuffer.infinitepower"
    compileSdk = 34

    defaultConfig {
        minSdk = 34
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    compileOnly(project(":hidden-api"))
    compileOnly(libs.hidden.stub)
}