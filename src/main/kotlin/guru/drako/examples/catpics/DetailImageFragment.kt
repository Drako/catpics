package guru.drako.examples.catpics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailImageFragment : Fragment(), KoinComponent {
  companion object {
    const val KEY_IMAGE_URL = "DetailImageFragment.ImageUrl"
  }

  private val picasso: Picasso by inject()

  var imageUrl: String = ""

  override fun onSaveInstanceState(outState: Bundle) {
    outState.putString(KEY_IMAGE_URL, imageUrl)
    super.onSaveInstanceState(outState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    savedInstanceState?.getString(KEY_IMAGE_URL)?.also { imageUrl ->
      this.imageUrl = imageUrl
    }

    return inflater.inflate(R.layout.fragment_image, container, false).also { view ->
      picasso.load(imageUrl).into(view.findViewById<ImageView>(R.id.detailImage))
    }
  }
}
