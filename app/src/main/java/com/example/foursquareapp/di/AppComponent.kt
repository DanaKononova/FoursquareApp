package com.example.foursquareapp.di

import android.content.Context
import com.example.foursquareapp.di.modules.*
import com.example.foursquareapp.ui.authorization.AuthorizationFragment
import com.example.foursquareapp.ui.history.HistoryFragment
import com.example.foursquareapp.ui.lauch.LaunchFragment
import com.example.foursquareapp.ui.nearby.NearbyFragment
import com.example.foursquareapp.ui.nearby.PlaceFragment
import com.example.foursquareapp.ui.profile.ProfileFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class,
        SourceModule::class, DataBaseModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: LaunchFragment)

    fun inject(fragment: NearbyFragment)

    fun inject(fragment: HistoryFragment)

    fun inject(fragment: ProfileFragment)

    fun inject(fragment: PlaceFragment)

    fun inject(fragment: AuthorizationFragment)

}