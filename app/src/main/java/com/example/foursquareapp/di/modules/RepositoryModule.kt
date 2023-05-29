package com.example.foursquareapp.di.modules

import com.example.foursquareapp.data.RepositoryImpl
import com.example.foursquareapp.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun getRepository(impl: RepositoryImpl): Repository

}