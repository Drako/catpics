package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

const val KOIN_VERSION = "2.0.1"

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.koin(module: String): String {
  return "org.koin:koin-$module:$KOIN_VERSION"
}
