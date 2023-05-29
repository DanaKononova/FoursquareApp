package com.example.foursquareapp.ui.nearby

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foursquareapp.databinding.RvDescriptionItemBinding

class DescriptionAdapter : RecyclerView.Adapter<DescriptionViewHolder>() {

    private val items = mutableListOf<String>()
    private val values = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {
        val binding =
            RvDescriptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
        holder.onBind(items[position], values[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setPlaces(list1: List<String>, list2: List<String>) {
        items.clear()
        items.addAll(list1)
        values.clear()
        values.addAll(list2)
        notifyDataSetChanged()
    }
}