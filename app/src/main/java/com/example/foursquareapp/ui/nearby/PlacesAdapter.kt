package com.example.foursquareapp.ui.nearby

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foursquareapp.databinding.RvNearbyItemBinding
import com.example.foursquareapp.domain.models.PlaceData

class PlacesAdapter (
    private val itemClick: (String) -> Unit
) : RecyclerView.Adapter<PlacesViewHolder>() {

    private val places = mutableListOf<PlaceData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        val binding =
            RvNearbyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlacesViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.onBind(places[position])
    }

    override fun getItemCount(): Int = places.size

    @SuppressLint("NotifyDataSetChanged")
    fun setPlaces(list: List<PlaceData>) {
        places.clear()
        places.addAll(list)
        notifyDataSetChanged()
    }
}