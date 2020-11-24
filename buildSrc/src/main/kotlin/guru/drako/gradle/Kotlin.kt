package guru.drako.gradle

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

const val KOTLIN_VERSION = "1.4.20"

fun DependencyHandler.kotlinArtifact(module: String) = kotlin(module, KOTLIN_VERSION)
