plugins {
    id("com.android.application")
}

android {
    namespace = "net.dkr.freelancing"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.dkr.freelancing"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0-alpha03")
    implementation("com.google.android.material:material:1.13.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    implementation("androidx.activity:activity:1.9.0")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.8.0-alpha07")
    implementation("androidx.annotation:annotation-jvm:1.7.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0-alpha03")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0-alpha03")

    // for GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    // for retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //circle imageView
    implementation("de.hdodenhof:circleimageview:3.1.0")
//    implementation("de.hdodenhof:circleimageview:3.1.0")


}