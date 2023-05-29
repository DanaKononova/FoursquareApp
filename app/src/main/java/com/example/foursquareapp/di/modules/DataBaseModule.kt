package com.example.foursquareapp.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    companion object{
        const val FOOD_LIST = "FoodList"
    }

//    @Provides
//    @Singleton
//    fun provideFoodDataBase(context: Context): FoodDataBase {
//        return Room.databaseBuilder(context, FoodDataBase::class.java, FOOD_LIST)
//            .build()
//    }
//
//
//    @Provides
//    @Singleton
//    fun provideFoodDao(db: FoodDataBase): FoodDao = db.foodDao()

}