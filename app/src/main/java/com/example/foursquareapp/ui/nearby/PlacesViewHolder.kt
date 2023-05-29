package com.example.foursquareapp.ui.nearby

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foursquareapp.databinding.RvNearbyItemBinding
import com.example.foursquareapp.domain.models.PlaceData

class PlacesViewHolder (
    private val binding: RvNearbyItemBinding,
    private val itemClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: PlaceData) {
        val placeTitle = binding.placeTitle
        placeTitle.text = item.name
        binding.placeType.text = item.typeName

        val photoUrl = item.prefix+"bg_88"+item.suffix
        Glide
            .with(itemView)
            .load(photoUrl)
            .into(binding.placeImage)

        itemView.setOnClickListener {
            itemClick.invoke(item.id)
        }
    }
}