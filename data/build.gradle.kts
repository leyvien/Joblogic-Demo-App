import com.joblogic.buildsrc.*
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.joblogic.data"
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_URL", "\"https://my-json-server.typicode.com/\"")
        }
        getByName("release") {
            buildConfigField("String", "API_URL", "\"https://my-json-server.typicode.com/\"")
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
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation (project (":domain"))
    implementation (Libs.coreKTX)
    implementation(Libs.retrofit)
    implementation(Libs.retrofitMoshiConverter)

    implementation(Libs.okhttp)
    implementation(Libs.okhttpLogging)

    implementation(Libs.coroutines)
    implementation(Libs.coroutinesAndroid)

    implementation(Libs.room)
    implementation(Libs.roomRuntime)
    kapt(Libs.roomCompiler)

    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)

    implementation(Libs.javaxInject)
}