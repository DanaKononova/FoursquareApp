package com.example.foursquareapp.ui.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquareapp.domain.Repository
import com.example.foursquareapp.domain.models.DescriptionData
import com.example.foursquareapp.domain.models.PhotoData
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlaceViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _descriptionLiveData = MutableLiveData<DescriptionData>()
    val descriptionLiveData: LiveData<DescriptionData> get() = _descriptionLiveData

    private val _photosLiveData = MutableLiveData<List<PhotoData>>()
    val photosLiveData: LiveData<List<PhotoData>> get() = _photosLiveData

    fun getPlaceDescription(fsq_id: String) {
        viewModelScope.launch() {
            _descriptionLiveData.value = repository.getPlaceDescription(fsq_id)
        }
    }

    fun getPhotos(fsq_id: String) {
        viewModelScope.launch() {
            _photosLiveData.value = repository.getPhotos(fsq_id)
        }
    }

}