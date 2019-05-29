package guru.drako.examples.catpics

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  fun handleOnClickButton(v: View) {
    showToast(R.string.hello_world)
  }

  override fun onDestroy() {
    super.onDestroy()
    cancel()
  }
}
