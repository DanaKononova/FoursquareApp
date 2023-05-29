package com.example.foursquareapp.data.models

import com.squareup.moshi.Json

data class CategoryResponse(
    @Json(name = "name") val name: String? = null,
    @Json(name = "icon") val icon: PhotoResponse? = null,
)