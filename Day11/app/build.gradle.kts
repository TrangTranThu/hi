plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.mvvc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvc"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // fragment
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // https://mvnrepository.com/artifact/androidx.navigation/navigation-fragment-ktx
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")

    // https://mvnrepository.com/artifact/androidx.navigation/navigation-ui-ktx
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-viewmodel-ktx
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")


}