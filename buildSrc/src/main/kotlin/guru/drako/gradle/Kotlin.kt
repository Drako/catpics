package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

const val KOTLIN_VERSION = "1.3.31"

fun DependencyHandler.kotlinArtifact(module: String) = kotlin(module, KOTLIN_VERSION)
