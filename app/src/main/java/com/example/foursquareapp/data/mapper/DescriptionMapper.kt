package com.example.foursquareapp.data.mapper

import com.example.foursquareapp.data.models.DescriptionResponse
import com.example.foursquareapp.domain.models.DescriptionData
import javax.inject.Inject

class DescriptionMapper @Inject constructor() {

    operator fun invoke(descriptionResponse: DescriptionResponse) = with(descriptionResponse) {
        DescriptionData(
            fsq_id = fsq_id ?: "",
            name = name ?: "",
            timezone = timezone ?: "",
            typeName = categories?.get(0)?.name ?: "",
            prefix = categories?.get(0)?.icon?.prefix ?: "",
            suffix = categories?.get(0)?.icon?.suffix ?: "",
            latitude = geocodes?.main?.latitude ?: 0f,
            longitude = geocodes?.main?.longitude ?: 0f,
            address = location?.address ?: "",
            country = location?.country ?: "",
            cross_street = location?.cross_street ?: "",
            region = location?.region ?: ""
        )
    }

}