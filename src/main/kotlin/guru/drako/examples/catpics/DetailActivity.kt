package guru.drako.examples.catpics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
  companion object {
    const val KEY_STATE = "DetailActivity.State"

    fun start(context: Context, imageUrls: Array<String>, currentImage: Int) {
      startActivity(context, Intent(context, DetailActivity::class.java).apply {
        putExtra(KEY_STATE, State(imageUrls, currentImage))
      }, null)
    }
  }

  @Parcelize
  class State(
    val imageUrls: Array<String>,
    val currentImage: Int
  ) : Parcelable

  private lateinit var state: State

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    state = savedInstanceState?.getParcelable(KEY_STATE)
      ?: intent.extras?.getParcelable<State>(KEY_STATE)
          ?: throw IllegalStateException("DetailActivity is missing required parameters.")

    pager.adapter = ImageAdapter()
    pager.currentItem = state.currentImage
  }

  override fun onSaveInstanceState(outState: Bundle?) {
    outState?.apply {
      putParcelable(KEY_STATE, State(
        imageUrls = state.imageUrls,
        currentImage = pager.currentItem
      ))
    }

    super.onSaveInstanceState(outState)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> onBackPressed()
    }
    return true
  }

  private inner class ImageAdapter : FragmentStatePagerAdapter(supportFragmentManager) {
    override fun getCount(): Int {
      return state.imageUrls.size
    }

    override fun getItem(position: Int): Fragment {
      return DetailImageFragment().apply {
        imageUrl = state.imageUrls[position]
      }
    }
  }
}
