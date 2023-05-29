package com.example.foursquareapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.foursquareapp.ui.history.HistoryViewModel
import com.example.foursquareapp.ui.nearby.NearbyViewModel
import com.example.foursquareapp.ui.nearby.PlaceViewModel
import com.example.foursquareapp.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NearbyViewModel::class)
    fun bindNearbyViewModel(viewModel: NearbyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    fun bindHistoryViewModel(viewModel: HistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlaceViewModel::class)
    fun bindPlaceViewModel(viewModel: PlaceViewModel): ViewModel

}