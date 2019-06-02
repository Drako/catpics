import guru.drako.gradle.*

plugins {
    id("com.android.application") version "3.4.1"
    kotlin("android") version "1.3.31"
    kotlin("android.extensions") version "1.3.31"
}

group = "guru.drako.examples.catpics"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    google()
    kotlinx()
}

android {
  compileSdkVersion(28)

  defaultConfig {
    minSdkVersion(17)
    targetSdkVersion(28)
    applicationId = "guru.drako.examples.catpics"
    vectorDrawables.generatedDensities("hdpi", "xxhdpi")
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    versionCode = 1
    versionName = "1.0"
  }

  sequenceOf("main", "test", "androidTest").forEach {
    sourceSets[it].java.srcDir("src/$it/kotlin")
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
    }

    getByName("debug") {
      applicationIdSuffix = ".debug"
      isDebuggable = true
    }
  }

  packagingOptions {
    exclude("META-INF/*.kotlin_module")
  }
}

androidExtensions {
  isExperimental = true
}

dependencies {
  implementation(kotlinArtifact("stdlib-jdk7"))
  implementation(kotlinArtifact("reflect"))
  testImplementation(kotlinArtifact("test-junit"))

  implementation(androidX(AndroidX.APPCOMPAT))
  implementation(androidX(AndroidX.CORE_KTX))
  implementation(androidX(AndroidX.CONSTRAINTLAYOUT))
  implementation(androidX(AndroidX.FRAGMENT_KTX))
  implementation(androidX(AndroidX.RECYCLERVIEW))
  implementation(androidX(AndroidX.SWIPEREFRESHLAYOUT))
  implementation(androidX(AndroidX.VECTORDRAWABLE))
  implementation(androidX(AndroidX.VIEWPAGER))

  implementation(ktxCoroutines("core"))
  implementation(ktxCoroutines("android"))

  implementation(ktorClient("android"))
  implementation(ktorClient("json"))
  implementation(ktorClient("gson"))

  implementation(koin("android"))
  implementation(koin("android-scope"))
  implementation(koin("android-viewmodel"))
  implementation(koin("android-ext"))

  implementation("com.squareup.picasso:picasso:2.71828")

  androidTestImplementation(kotlinArtifact("test-junit"))
  androidTestImplementation("androidx.test:runner:1.1.1")
  androidTestImplementation("androidx.test:rules:1.1.1")
  androidTestImplementation("androidx.test.ext:junit-ktx:1.1.1")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}

tasks {
  "wrapper"(Wrapper::class) {
    gradleVersion = "5.4.1"
  }

  "clean"(Delete::class) {
    setDelete(rootProject.buildDir)
  }
}

