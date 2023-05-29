package com.example.foursquareapp.ui.nearby

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foursquareapp.databinding.RvImageBinding

class ImageAdapter : RecyclerView.Adapter<ImageViewHolder>() {

    private val images = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            RvImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(images[position])
    }

    override fun getItemCount(): Int = images.size

    @SuppressLint("NotifyDataSetChanged")
    fun setImages(list: List<String>) {
        images.clear()
        images.addAll(list)
        notifyDataSetChanged()
    }
}