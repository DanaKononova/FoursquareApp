package com.example.foursquareapp.data.mapper

import com.example.foursquareapp.data.models.PhotoResponse
import com.example.foursquareapp.domain.models.PhotoData
import javax.inject.Inject

class PhotoMapper @Inject constructor() {

    operator fun invoke(photoResponse: PhotoResponse) = with(photoResponse) {
        PhotoData(
            prefix = prefix ?: "",
            suffix = suffix ?: ""
        )
    }

}