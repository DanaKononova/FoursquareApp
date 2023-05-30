package com.example.foursquareapp.data.db

import androidx.room.*

@Dao
interface PlacesDao {

    @Query("SELECT * FROM places_table")
    fun getAllPlaces(): List<PlacesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPlaces(news: List<PlacesEntity>)

    @Delete
    fun deleteAllPlaces(news: List<PlacesEntity>)

}