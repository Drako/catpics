package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler

const val KOTLINX_COROUTINES_VERSION = "1.2.1"

@Suppress("unused") // receiver is used for scoping
fun DependencyHandler.ktxCoroutines(module: String): String {
  return "org.jetbrains.kotlinx:kotlinx-coroutines-$module:$KOTLINX_COROUTINES_VERSION"
}
