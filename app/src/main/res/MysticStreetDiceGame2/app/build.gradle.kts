plugins {
    id("com.android.application")

}
android {
    namespace = "com.example.mysticstreetdicegame2"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mysticstreetdicegame2"
        minSdk = 30
        targetSdk = 33
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


    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/LICENSE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/NOTICE")
        exclude("org/apache/http/version.properties")
        exclude("org/apache/http/client/version.properties")
    }
    buildFeatures {
        viewBinding = true
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    viewBinding {
        enable = true
    }


}

dependencies {




    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
        because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
    }
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
        because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
    }


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.annotation:annotation:1.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.preference:preference:1.2.1")
    testImplementation("junit:junit:4.1+")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    implementation("androidx.navigation:navigation-fragment:2.5.3")
//    implementation("androidx.navigation:navigation-ui:2.5.3")
//    implementation("androidx.preference:preference:1.2.1")
//    implementation("androidx.mediarouter:mediarouter:1.4.0")
//    implementation("com.google.android.gms:play-services-base:18.2.0")
//    implementation("com.google.firebase:firebase-messaging:23.2.1")
//    implementation("com.google.android.gms:play-services-auth:20.7.0")
//    implementation("com.google.android.gms:play-services-ads-lite:22.3.0")
//    implementation("com.google.android.gms:play-services-cast-framework:21.3.0")


    //Rounded imageView
    implementation("com.makeramen:roundedimageview:2.3.0")

    //branch
//    implementation("io.branch.sdk.android:library:5.7.0")

    //RETRO FIT
//    implementation("com.google.code.gson:gson:2.8.6")
//    implementation("com.squareup.retrofit2:converter-gson:2.1.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")
//    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    // implementation "io.reactivex.rxjava3:rxjava:3.1.1"



    //firebase
//    implementation("com.google.firebase:firebase-bom:29.0.1")
//    implementation("com.google.android.gms:play-services-auth:19.2.0")
////    implementation("com.facebook.android:facebook-android-sdk:4.10.0")
//    implementation("com.facebook.android:facebook-login:latest.release")
//    implementation("com.google.apis:google-api-services-people:v1-rev354-1.25.0")
//    implementation("com.google.api-client:google-api-client-android:1.23.0")
//    {
//        exclude group: 'org.apache.httpcomponents'
//    }
//    implementation("com.google.guava:guava:27.0.1-android")
//    implementation("com.facebook.fresco:fresco:2.3.0")

    //shimmer
//    implementation("com.facebook.shimmer:shimmer:0.5.0")


    //RETRO FIT
//    implementation("com.google.code.gson:gson:2.8.6")
//    implementation("com.squareup.retrofit2:converter-gson:2.1.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")
//    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    // implementation "io.reactivex.rxjava3:rxjava:3.1.1"


    //lotti
    implementation("com.airbnb.android:lottie:3.6.1")
//    implementation("")
//    implementation("")
//    implementation("")
//    implementation("")


//    implementation "androidx.multidex:multidex:2.0.1"


    // ads
//    implementation("com.google.android.gms:play-services-ads:22.1.0")

}