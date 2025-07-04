plugins {
    id("com.android.application")
}

android {
    namespace = "org.helal.unitconvertor"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.helal.unitconvertor"
        minSdk = 26
        maxSdk=32
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation("androidx.navigation:navigation-fragment:2.8.2")
    implementation("androidx.navigation:navigation-ui:2.8.2")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("commons-io:commons-io:2.16.1")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}