package guru.drako.examples.catpics

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(this, message, duration).show()
}

fun Context.showToast(@StringRes messageId: Int, vararg values: Any, duration: Int = Toast.LENGTH_SHORT) {
  val message = getString(messageId, *values)
  Toast.makeText(this, message, duration).show()
}
