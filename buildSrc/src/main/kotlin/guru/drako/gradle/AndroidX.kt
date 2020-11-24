package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

@Suppress("unused", "SpellCheckingInspection")
enum class AndroidX(val version: String) {
  APPCOMPAT(version = "1.2.0"),
  CONSTRAINTLAYOUT(version = "2.0.4"),
  CORE_KTX(version = "1.3.2"),
  FRAGMENT_KTX(version = "1.2.5"),
  LIFECYCLE_EXTENSIONS(version = "2.2.0"),
  MULTIDEX(version = "2.0.1"),
  PREFERENCE_KTX(version = "1.1.1"),
  RECYCLERVIEW(version = "1.1.0"),
  SWIPEREFRESHLAYOUT(version = "1.1.0"),
  VECTORDRAWABLE(version = "1.1.0"),
  VIEWPAGER(version = "1.0.0");
}

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.androidX(module: AndroidX) = with(module) {
  val artifact = name.toLowerCase().replace('_', '-')
  val group = "androidx." + artifact.substringBefore('-')
  return@with "$group:$artifact:$version"
}
