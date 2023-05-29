package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class LocationResponse(
    @Json(name = "address") val address: String? = null,
    @Json(name = "country") val country: String? = null,
    @Json(name = "cross_street") val cross_street: String? = null,
    @Json(name = "region") val region: String? = null,
)