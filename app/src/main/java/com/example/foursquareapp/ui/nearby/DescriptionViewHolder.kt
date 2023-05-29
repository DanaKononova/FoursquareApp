package com.example.foursquareapp.ui.nearby

import androidx.recyclerview.widget.RecyclerView
import com.example.foursquareapp.databinding.RvDescriptionItemBinding

class DescriptionViewHolder (
    private val binding: RvDescriptionItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: String, value: String) {
        binding.descriptionItem.text = item
        binding.descriptionTv.text = value
    }

}