package guru.drako.examples.catpics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.image_list_item.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.properties.Delegates

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
  var imageUrls: List<String> by Delegates.observable(listOf()) { _, _, _ ->
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater
      .from(parent.context)
      .inflate(R.layout.image_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return imageUrls.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(imageUrls[position])
    holder.itemView.setOnClickListener { view ->
      DetailActivity.start(view.context, imageUrls.toTypedArray(), position)
    }
  }

  class ViewHolder(
    override val containerView: View
  ) : RecyclerView.ViewHolder(containerView), LayoutContainer, KoinComponent {
    val picasso: Picasso by inject()

    fun bind(url: String) {
      picasso.load(url).into(imageView)
    }
  }
}