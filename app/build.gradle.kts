plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mwema.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mwema.myapplication"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "NewsApp-1.0"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //picaso for image loading
    // https://mvnrepository.com/artifact/com.squareup.picasso3/picasso
    implementation("com.squareup.picasso3:picasso:3.0.0-alpha06")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}