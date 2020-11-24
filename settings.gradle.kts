rootProject.name = "catpics"

val knownPlugins = mapOf(
    "com.android.application" to "com.android.tools.build:gradle",
    "com.android.library" to "com.android.tools.build:gradle"
)

pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
  }
  resolutionStrategy {
    eachPlugin {
      when ("${requested.id}") {
        "com.android.application" -> useModule("com.android.tools.build:gradle:${requested.version}")
        "com.android.library" -> useModule("com.android.tools.build:gradle:${requested.version}")
      }
    }
  }
}

