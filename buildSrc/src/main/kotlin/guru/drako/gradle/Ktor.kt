package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

const val KTOR_VERSION = "1.2.0"

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.ktorClient(module: String): String {
  return "io.ktor:ktor-client-$module:$KTOR_VERSION"
}
