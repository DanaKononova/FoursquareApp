package com.example.foursquareapp.data.mapper

import com.example.foursquareapp.data.db.PlacesEntity
import com.example.foursquareapp.data.models.PlaceResponse
import com.example.foursquareapp.domain.models.PlaceData
import javax.inject.Inject

class PlaceMapper @Inject constructor() {

    operator fun invoke(placesEntity: PlacesEntity) = with(placesEntity) {
        PlaceData(
            id = id,
            name = name,
            typeName = type,
            prefix = prefix,
            suffix = suffix
        )
    }

    fun toPlacesEntity(placeResponse: PlaceResponse) = with(placeResponse) {
        PlacesEntity(
            id = fsq_id ?: "",
            name = name ?: "",
            type = categories?.get(0)?.name ?: "",
            prefix = categories?.get(0)?.icon?.prefix ?: "",
            suffix = categories?.get(0)?.icon?.suffix ?: ""
        )
    }

}