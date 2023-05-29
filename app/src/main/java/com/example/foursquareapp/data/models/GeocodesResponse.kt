package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class GeocodesResponse(
    @Json(name = "main") val main: MainResponse? = null,
)