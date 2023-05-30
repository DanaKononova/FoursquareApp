package com.example.foursquareapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.foursquareapp.data.db.PlacesDao
import com.example.foursquareapp.data.db.PlacesDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    companion object {
        const val PLACES_LIST = "PlacesList"
    }

    @Provides
    @Singleton
    fun providePlacesDataBase(context: Context): PlacesDataBase {
        return Room.databaseBuilder(context, PlacesDataBase::class.java, PLACES_LIST)
            .build()
    }


    @Provides
    @Singleton
    fun providePlacesDao(db: PlacesDataBase): PlacesDao = db.placesDao()

}