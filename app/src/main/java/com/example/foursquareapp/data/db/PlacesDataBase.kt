package com.example.foursquareapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PlacesEntity::class],
    version = 1
)
abstract class PlacesDataBase : RoomDatabase() {
    abstract fun placesDao(): PlacesDao
}