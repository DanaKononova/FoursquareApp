package com.example.foursquareapp.data.network

import com.example.foursquareapp.data.models.DescriptionResponse
import com.example.foursquareapp.data.models.PhotoResponse
import com.example.foursquareapp.data.models.PlacesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FoursquareService {

    @Headers("Authorization:ffsq3crsgDYoLd3Fgndgs0W1yK9Qnn5V5q/1t8GI3u6+2x3Y=")
    @GET("places/search")
    suspend fun getPlaces(
        @Query("ll") ll: String,
        @Query("radius") radius: Int,
        @Query("limit") limit: Int,
    ): PlacesResponse

    @Headers("Authorization:fsq3crsgDYoLd3Fgndgs0W1yK9Qnn5V5q/1t8GI3u6+2x3Y=")
    @GET("places/{fsq_id}")
    suspend fun getDescription(
        @Path("fsq_id") fsq_id: String,
    ): DescriptionResponse

    @Headers("Authorization:fsq3crsgDYoLd3Fgndgs0W1yK9Qnn5V5q/1t8GI3u6+2x3Y=")
    @GET("places/{fsq_id}/photos")
    suspend fun getPhoto(
        @Path("fsq_id") fsq_id: String,
    ): List<PhotoResponse>

}