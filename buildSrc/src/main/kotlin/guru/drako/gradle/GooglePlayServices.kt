package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

enum class PlayService(val version: String) {
  LOCATION("16.0.0")
}

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.google(service: PlayService): String {
  return "com.google.android.gms:play-services-${service.toString().toLowerCase()}:${service.version}"
}
