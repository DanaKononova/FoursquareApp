package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class MainResponse(
    @Json(name = "latitude") val latitude: Float? = null,
    @Json(name = "longitude") val longitude: Float? = null,
)