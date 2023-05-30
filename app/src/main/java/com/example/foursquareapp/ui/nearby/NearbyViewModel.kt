package com.example.foursquareapp.ui.nearby

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquareapp.domain.Repository
import com.example.foursquareapp.domain.models.PlaceData
import kotlinx.coroutines.launch
import javax.inject.Inject

class NearbyViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _placesLiveData = MutableLiveData<List<PlaceData>>()
    val placesLiveData: LiveData<List<PlaceData>> get() = _placesLiveData

    fun getPlaces(ll: String, radius: Int, limit: Int, context: Context) {
        viewModelScope.launch() {
            if (isNetworkConnected(context))
                _placesLiveData.value = repository.getPlaces(ll, radius, limit)
            else _placesLiveData.value = repository.getPlacesFromDb()
        }
    }

    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(network) ?: return false

            return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false

            return networkInfo.isConnected
        }
    }

}