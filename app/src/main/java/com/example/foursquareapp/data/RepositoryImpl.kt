package com.example.foursquareapp.data

import com.example.foursquareapp.data.mapper.DescriptionMapper
import com.example.foursquareapp.data.mapper.PhotoMapper
import com.example.foursquareapp.data.mapper.PlaceMapper
import com.example.foursquareapp.data.network.FoursquareService
import com.example.foursquareapp.data.source.PlacesDataBaseSource
import com.example.foursquareapp.domain.Repository
import com.example.foursquareapp.domain.models.DescriptionData
import com.example.foursquareapp.domain.models.PhotoData
import com.example.foursquareapp.domain.models.PlaceData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: FoursquareService,
    private val placeMapper: PlaceMapper,
    private val photoMapper: PhotoMapper,
    private val descriptionMapper: DescriptionMapper,
    private val dataBaseSource: PlacesDataBaseSource,
) : Repository {

    override suspend fun getPlaces(ll: String, radius: Int, limit: Int): List<PlaceData> {
        return withContext(Dispatchers.IO) {
            val response = service.getPlaces(ll, radius, limit).results
            val entity = (response ?: listOf()).map { placeMapper.toPlacesEntity(it) }
            dataBaseSource.insertAllPlaces(entity)
            (entity).map { placeMapper(it) }
        }
    }

    override suspend fun getPlacesFromDb(): List<PlaceData> {
        return withContext(Dispatchers.IO) {
            val entity = dataBaseSource.getAllPlaces()
            (entity).map { placeMapper(it) }
        }
    }

    override suspend fun deletePlacesFromDb() {
        withContext(Dispatchers.IO) {
            dataBaseSource.deleteAllPlaces(dataBaseSource.getAllPlaces())
        }
    }

    override suspend fun getPlaceDescription(fsq_id: String): DescriptionData {
        return withContext(Dispatchers.IO) {
            val response = service.getDescription(fsq_id)
            descriptionMapper(response)
        }
    }

    override suspend fun getPhotos(fsq_id: String): List<PhotoData> {
        return withContext(Dispatchers.IO) {
            val response = service.getPhoto(fsq_id)
            (response).map { photoMapper(it) }
        }
    }

}