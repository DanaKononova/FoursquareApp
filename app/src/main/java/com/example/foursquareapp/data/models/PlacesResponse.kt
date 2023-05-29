package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class PlacesResponse (
    @Json(name ="results") val results: List<PlaceResponse>? = null
)