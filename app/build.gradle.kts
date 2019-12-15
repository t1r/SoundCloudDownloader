import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"

    defaultConfig {
        applicationId = "com.t1r.scd"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("prod") {
            //todo put key params for release
            storeFile = file("../keys/play/key.jks")
            storePassword = "pass"
            keyAlias = "alias"
            keyPassword = "pass"
        }
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "SC_CLIENT_ID", "\"" + getClientId() + "\"")

            isMinifyEnabled = false
            versionNameSuffix = "_debug"

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        getByName("release") {
            buildConfigField("String", "SC_CLIENT_ID", "\"" + getClientId() + "\"")

            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("prod")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }

    flavorDimensions("target")
    productFlavors {
        create("mock") {
            setDimension("target")
            buildConfigField("String", "BASE_URL","\"https://api-v2.soundcloud.com/\"")
            versionNameSuffix = "_mock"
        }
        create("prod") {
            setDimension("target")
            buildConfigField("String", "BASE_URL","\"https://api-v2.soundcloud.com/\"")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KotlinCompilerVersion.VERSION}")

    //UI
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    //Network
    val ktorVersion = "1.2.6"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-mock-jvm:$ktorVersion")


    //DI
    val daggerVersion = "2.24"
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation("com.google.dagger:dagger:$daggerVersion")

    //Test
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

fun getClientId() : String {
    val keysFile = rootProject.file("keys.properties")
    val keysProperties = Properties()
    keysProperties.load(FileInputStream(keysFile))
    return keysProperties.getProperty("SC_CLIENT_ID")
}