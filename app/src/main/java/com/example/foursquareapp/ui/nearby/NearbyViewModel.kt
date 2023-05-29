package com.example.foursquareapp.ui.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquareapp.domain.Repository
import com.example.foursquareapp.domain.models.PlaceData
import kotlinx.coroutines.launch
import javax.inject.Inject

class NearbyViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _placesLiveData = MutableLiveData<List<PlaceData>>()
    val placesLiveData: LiveData<List<PlaceData>> get() = _placesLiveData

    fun getPlaces(ll: String, radius: Int, limit: Int) {
        viewModelScope.launch() {
            _placesLiveData.value = repository.getPlaces(ll, radius, limit)
        }
    }

}