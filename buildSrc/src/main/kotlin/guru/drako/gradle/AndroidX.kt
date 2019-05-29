package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

@Suppress("unused", "SpellCheckingInspection")
enum class AndroidX(val version: String) {
  APPCOMPAT(version = "1.0.2"),
  CONSTRAINTLAYOUT(version = "1.1.3"),
  CORE_KTX(version = "1.0.1"),
  FRAGMENT_KTX(version = "1.0.0"),
  LIFECYCLE_EXTENSIONS(version = "2.0.0"),
  PREFERENCE_KTX(version = "1.1.0-alpha03"),
  RECYCLERVIEW(version = "1.0.0"),
  VECTORDRAWABLE(version = "1.0.1");
}

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.androidX(module: AndroidX) = with(module) {
  val artifact = name.toLowerCase().replace('_', '-')
  val group = "androidx." + artifact.substringBefore('-')
  return@with "$group:$artifact:$version"
}
