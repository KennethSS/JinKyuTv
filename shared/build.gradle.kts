plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "JinKyuTv"
            isStatic = true
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.ui)
                implementation(libs.compose.util)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.ktor.core)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.serialization.json)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.exoplayer)
                implementation(libs.exoplayer.dash)
                implementation(libs.exoplayer.ui)
                implementation(libs.koin.androidx.compose)
                implementation(libs.ktor.android)
                implementation(libs.compose.navigation)
            }
        }
        val iosMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(libs.ktor.ios)
            }
        }
    }
}

android {
    namespace = "com.jinkyu.tv"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
}
