package guru.drako.examples.catpics

import android.os.Bundle
import android.view.Surface.ROTATION_270
import android.view.Surface.ROTATION_90
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

  companion object {
    const val KEY_IMAGE_URLS = "MainActivity.ImageUrls"
  }

  private val catImageAdapter = ImageAdapter()

  private val catApi: CatApi by inject()

  private fun loadCatPics(v: View? = null) {
    launch {
      catImageAdapter.imageUrls = catApi.getCatPics(limit = 6).map { metaData ->
        metaData.url
      }
      swiper.isRefreshing = false
    }
  }

  private var RecyclerView.spanCount: Int
    get() = (layoutManager as GridLayoutManager).spanCount
    set(value) {
      (layoutManager as GridLayoutManager).spanCount = value
    }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    when (getSystemService<WindowManager>()!!.defaultDisplay.rotation) {
      ROTATION_90 -> catList.spanCount = 3
      ROTATION_270 -> catList.spanCount = 3
      else -> catList.spanCount = 2
    }

    catList.adapter = catImageAdapter

    savedInstanceState?.getStringArray(KEY_IMAGE_URLS)?.also { imageUrls ->
      catImageAdapter.imageUrls = imageUrls.toList()
    } ?: loadCatPics()

    swiper.setOnRefreshListener {
      loadCatPics()
    }
  }

  override fun onSaveInstanceState(outState: Bundle?) {
    outState?.apply {
      putStringArray(KEY_IMAGE_URLS, catImageAdapter.imageUrls.toTypedArray())
    }

    super.onSaveInstanceState(outState)
  }

  override fun onDestroy() {
    super.onDestroy()
    cancel()
  }
}
