plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}
ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}
android {
    namespace = "com.anthonyla.paperize"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anthonyla.paperize"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
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
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

androidComponents {
    onVariants(selector().withBuildType("release")) {
        it.packaging.resources.excludes.add("META-INF/**")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-alpha03")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui:1.6.0-alpha08")
    implementation("androidx.compose.ui:ui-graphics:1.6.0-alpha08")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0-alpha08")
    implementation("androidx.compose.material3:material3:1.2.0-alpha10")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.compose.material:material:1.6.0-alpha08")
    implementation("androidx.datastore:datastore:1.1.0-alpha05")
    implementation("androidx.datastore:datastore-preferences:1.1.0-alpha05")
    implementation("androidx.compose.material:material-icons-extended:1.6.0-alpha08")
    implementation("com.google.accompanist:accompanist-adaptive:0.33.2-alpha")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-rc01")
    implementation("androidx.compose.animation:animation:1.6.0-alpha08")
    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0-alpha03")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.documentfile:documentfile:1.1.0-alpha01")
    implementation("net.engawapg.lib:zoomable:1.5.1")
    implementation("com.github.skydoves:landscapist-glide:2.2.10")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.0-alpha08")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0-alpha08")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")
    implementation("com.google.dagger:hilt-android:2.48.1")
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")
    implementation("androidx.room:room-runtime:2.6.0")
    ksp("androidx.room:room-compiler:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0")
    implementation("com.lazygeniouz:dfc:1.0.8")
}