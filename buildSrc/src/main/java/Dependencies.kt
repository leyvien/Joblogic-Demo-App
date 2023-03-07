package com.joblogic.buildsrc

object Apps {
    const val compileSdk = 33
    const val buildToolsVersion = "32.0.0"
    const val minSdk = 24
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.0"
    const val kotlin = "1.3.50"
    const val coroutines = "1.6.4"

    const val coreKTX = "1.9.0"
    const val activityKTX = "1.5.1"
    const val fragmentKTX = "1.5.5"

    const val hilt = "2.44"
    const val appcompat = "1.5.0"
    const val navigation = "2.5.3"
    const val constraintLayout = "2.1.4"
    const val material = "1.8.0"
    const val recyclerView = "1.2.1"
    const val cardView = "1.0.0"
    const val lifecycle = "2.5.1"
    const val lifecycleExtension = "2.2.0"
    const val room = "2.4.3"

    const val retrofit = "2.9.0"
    const val okhttp3 = "4.10.0"
    const val moshi = "1.13.0"
    const val viewBindingPropertyDelegate = "1.5.6"
    const val timber = "5.0.1"
    const val javaxInject = "1"


    /* test */
    const val junit = "4.13.2"
    const val androidxJUnit = "1.1.5"
    const val androidxEspressoCore = "3.4.0"
    const val coroutineTest = "1.6.4"
    const val mockk = "1.13.2"
    const val okhttp3MockWebServer = "4.10.0"
    const val truth = "1.1.3"
    const val roomTesting = "2.4.3"
    const val turbine = "0.12.0"
    const val robolectric = "4.9"
    const val androidxCoreTesting = "2.1.0"
}

object Libs {
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coreKTX = "androidx.core:core-ktx:${Versions.coreKTX}"
    const val activityKTX = "androidx.activity:activity-ktx:${Versions.activityKTX}"
    const val fragmentKTX = "androidx.fragment:fragment-ktx:${Versions.fragmentKTX}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"

    //hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    //navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //lifecycle
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewmodelKTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtension}"


    //room
    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val roomPaging = "androidx.room:room-paging:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler =  "androidx.room:room-compiler:${Versions.room}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    //okhttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"

    //coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //moshi
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"


    //viewBindingPropertyDelegate
    const val viewBindingPropertyDelegate = "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBindingPropertyDelegate}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJUnit = "androidx.test.ext:junit:${Versions.androidxJUnit}"
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:${Versions.androidxEspressoCore}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val okhttp3MockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp3MockWebServer}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val roomTesting = "androidx.room:room-testing:${Versions.roomTesting}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
    const val robolectric ="org.robolectric:robolectric:${Versions.robolectric}"
    const val androidxCoreTesting = "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
}