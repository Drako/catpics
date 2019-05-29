package guru.drako.examples.catpics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    clickMe.setOnClickListener {
      showToast(R.string.hello_world)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    cancel()
  }
}
