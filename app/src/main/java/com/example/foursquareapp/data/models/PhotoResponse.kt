package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class PhotoResponse(
    @Json(name = "prefix") val prefix: String? = null,
    @Json(name = "suffix") val suffix: String? = null,
)