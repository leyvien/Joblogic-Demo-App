import com.joblogic.buildsrc.*
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs")
}

android {
    namespace = "com.joblogic.presentation"
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation (project (":domain"))
    implementation (Libs.coreKTX)
    implementation(Libs.fragmentKTX)
    implementation (Libs.appcompat)
    implementation (Libs.material)
    implementation (Libs.constraintLayout)
    implementation (Libs.recyclerView)
    implementation (Libs.cardView)
    implementation(Libs.viewBindingPropertyDelegate)
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)
    implementation (Libs.navigationFragment)
    implementation (Libs.navigationUi)

    testImplementation (TestLibs.junit)
    androidTestImplementation (TestLibs.androidxJUnit)
    androidTestImplementation (TestLibs.androidxEspressoCore)
    testImplementation(TestLibs.mockk)
    testImplementation (TestLibs.truth)
    testImplementation (TestLibs.androidxCoreTesting)
    testImplementation (TestLibs.coroutineTest)
}