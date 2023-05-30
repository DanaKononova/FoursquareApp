package com.example.foursquareapp.domain

import com.example.foursquareapp.domain.models.DescriptionData
import com.example.foursquareapp.domain.models.PhotoData
import com.example.foursquareapp.domain.models.PlaceData

interface Repository {

    suspend fun getPlaces(ll:String, radius:Int, limit: Int): List<PlaceData>

    suspend fun getPlacesFromDb(): List<PlaceData>

    suspend fun deletePlacesFromDb()

    suspend fun getPlaceDescription(fsq_id: String): DescriptionData

    suspend fun getPhotos(fsq_id: String): List<PhotoData>

}