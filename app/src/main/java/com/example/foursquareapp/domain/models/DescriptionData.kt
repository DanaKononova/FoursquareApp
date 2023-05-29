package com.example.foursquareapp.domain.models

data class DescriptionData(
    val fsq_id: String,
    val name: String,
    val timezone: String,
    val typeName: String,
    val prefix: String,
    val suffix: String,
    val latitude: Float,
    val longitude: Float,
    val address: String,
    val country: String,
    val cross_street: String,
    val region: String,
)