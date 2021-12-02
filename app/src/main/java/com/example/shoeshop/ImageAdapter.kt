package com.example.shoeshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ImageAdapter(
    private val context: Context,
    private val images: List<Image>
): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img = itemView.findViewById<ImageView>(R.id.image)
        val imgtitle = itemView.findViewById<TextView>(R.id.image_title)
        val imgprice = itemView.findViewById<TextView>(R.id.tvPrice)
        val imgtype = itemView.findViewById<TextView>(R.id.tvType)
        fun bindView(image: Image){
            img.setImageResource(image.imageSrc)
            imgtitle.text = image.title
            imgprice.text = image.price
            imgtype.text = image.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_images,parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}