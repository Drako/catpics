package guru.drako.examples.catpics

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

class CatApi {
  private val client = HttpClient(Android)
}
