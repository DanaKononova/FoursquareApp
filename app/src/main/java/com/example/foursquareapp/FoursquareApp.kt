package com.example.foursquareapp

import android.app.Application
import com.example.foursquareapp.di.AppComponent
import com.example.foursquareapp.di.DaggerAppComponent

class FoursquareApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}