package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

const val KTOR_VERSION = "1.4.2"

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.ktorClient(module: String): String {
  return "io.ktor:ktor-client-$module:$KTOR_VERSION"
}
