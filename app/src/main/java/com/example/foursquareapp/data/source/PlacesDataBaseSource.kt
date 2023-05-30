package com.example.foursquareapp.data.source

import com.example.foursquareapp.data.db.PlacesDao
import com.example.foursquareapp.data.db.PlacesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlacesDataBaseSource @Inject constructor(
    private val placesDao: PlacesDao,
) {

    suspend fun getAllPlaces() = withContext(Dispatchers.IO) {
        placesDao.getAllPlaces()
    }

    suspend fun insertAllPlaces(places: List<PlacesEntity>) = withContext(Dispatchers.IO) {
        placesDao.insertAllPlaces(places)
    }

    suspend fun deleteAllPlaces(places: List<PlacesEntity>) = withContext(Dispatchers.IO) {
        placesDao.deleteAllPlaces(places)
    }

}