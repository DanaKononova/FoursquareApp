package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class PlaceResponse (
    @Json(name ="fsq_id") val fsq_id: String? = null,
    @Json(name ="categories") val categories: List<CategoryResponse>? = null,
    @Json(name ="name") val name: String? = null
)