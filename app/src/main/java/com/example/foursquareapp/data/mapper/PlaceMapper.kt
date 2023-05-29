package com.example.foursquareapp.data.mapper

import com.example.foursquareapp.data.models.PlaceResponse
import com.example.foursquareapp.domain.models.PlaceData
import javax.inject.Inject

class PlaceMapper @Inject constructor() {

    operator fun invoke(placeResponse: PlaceResponse) = with(placeResponse) {
        PlaceData(
            id = fsq_id ?: "",
            name = name ?: "",
            typeName = categories?.get(0)?.name ?: "",
            prefix = categories?.get(0)?.icon?.prefix ?: "",
            suffix = categories?.get(0)?.icon?.suffix ?: ""
        )
    }

}