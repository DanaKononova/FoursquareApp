package com.example.foursquareapp.ui.nearby

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foursquareapp.databinding.RvImageBinding

class ImageViewHolder(
    private val binding: RvImageBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: String) {
        Glide
            .with(itemView)
            .load(item)
            .into(binding.placePhoto)
    }
}