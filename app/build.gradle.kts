plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.autocompletetextbox"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.autocompletetextbox"
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
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)

    //Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Recycler View
    implementation(libs.androidx.recyclerview)

    //Glide
    implementation(libs.glide)

    //Gson Converter
    implementation(libs.gson)

    //Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //Components
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //Dagger - Hilt
    implementation(libs.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)
    // Notes: Keep in mind the mapping of kapt version must be capable with kotlin version.
    // Please check the kapt and kotlin version must be capable with each other

    //SDP
    implementation(libs.sdp.android)

    //Swipe Refresh
    implementation(libs.androidx.swiperefreshlayout)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // RxAndroid
    implementation(libs.rxandroid)
    //RxKotlin (RxJava Already Included in RxKotlin)
    implementation(libs.rxkotlin)

    //RxJava with Retrofit Adapter
    //implementation(libs.retrofit2.adapter.rxjava2)
    implementation (libs.retrofit2.adapter.rxjava3)

    // Navigation Components
    /*implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)*/

    // Room
    /*implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    kapt(libs.sqlite.jdbc)*/

    // Kotlin Extensions and Coroutines support for Room
    /*implementation(libs.androidx.room.ktx)*/

    // Preference DataStore
    /*implementation(libs.androidx.datastore.preferences)*/

    //Range Time Picker
    /*implementation(libs.android.material.ranged.time.picker.dialog)*/

    //Dexter Permission
    /*implementation(libs.dexter)*/

    //Circular image
    /*implementation(libs.circleimageview)*/

    //Power Menu
    /*implementation(libs.powermenu)*/

    //Image Picker
    /*implementation(libs.fishbun)*/

    //Compress Image
    /*implementation(libs.compressor)*/

    //Color Picker
    /*implementation(libs.color.picker)*/

    //RecycleView Swiped Decorator
    /*implementation(libs.recyclerview.swipedecorator)*/

    //Image Crop
    /*implementation(libs.ucropnedit)*/

    //Seek Bar
    /*implementation(libs.circularSeekBar)*/

    //scrolling pager indicator
    //implementation (libs.scrollingpagerindicator)

    //Pull Refresh
    /*implementation (libs.pull.to.refresh)*/

    //okhttp
    implementation(libs.okhttp)
    implementation (libs.logging.interceptor)

    //Java Web Socket
    implementation (libs.java.web.socket)

    //Fuzzy Macher
    implementation ("me.xdrop:fuzzywuzzy:1.3.1")
}
kapt {
    correctErrorTypes = true
}