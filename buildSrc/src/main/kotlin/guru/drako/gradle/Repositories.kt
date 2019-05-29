package guru.drako.gradle

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.kotlinx() = maven(url = "https://kotlin.bintray.com/kotlinx/")
