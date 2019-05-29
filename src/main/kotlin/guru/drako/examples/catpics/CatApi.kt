package guru.drako.examples.catpics

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

data class CatMetaData(
  val url: String
)

class CatApi {
  private val client = HttpClient(Android) {
    install(JsonFeature) {
      serializer = GsonSerializer()
    }
  }

  suspend fun getCatPics(limit: Int = 10): List<CatMetaData> {
    return client
      .get("https://api.thecatapi.com/v1/images/search?limit=$limit")
  }
}
