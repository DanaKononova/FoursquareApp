package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class DescriptionResponse(
    @Json(name = "fsq_id") val fsq_id: String? = null,
    @Json(name = "categories") val categories: List<CategoryResponse>? = null,
    @Json(name = "geocodes") val geocodes: GeocodesResponse? = null,
    @Json(name = "location") val location: LocationResponse? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "timezone") val timezone: String? = null,
)