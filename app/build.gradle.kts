plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.hourlyproduction.report"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.hourlyproduction.report"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
