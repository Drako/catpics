package guru.drako.examples.catpics

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
  val catImageAdapter = ImageAdapter()

  val catApi: CatApi by inject()

  fun loadCatPics(v: View? = null) {
    launch {
      catImageAdapter.imageUrls = catApi.getCatPics(limit = 6).map { metaData ->
        metaData.url
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    catList.adapter = catImageAdapter

    loadCatPics()
  }

  override fun onDestroy() {
    super.onDestroy()
    cancel()
  }
}
