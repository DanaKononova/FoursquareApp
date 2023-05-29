package com.example.foursquareapp.data.network

import com.example.foursquareapp.data.models.DescriptionResponse
import com.example.foursquareapp.data.models.PhotoResponse
import com.example.foursquareapp.data.models.PlacesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FoursquareService {

    @Headers("Authorization:fsq3vLSgyS1mqNabHSVSYN3ECYm9Ss/adBCjK6ykMb0QUlc=")
    @GET("places/search")
    suspend fun getPlaces(
        @Query("ll") ll: String,
        @Query("radius") radius: Int,
        @Query("limit") limit: Int,
    ): PlacesResponse

    @Headers("Authorization:fsq3vLSgyS1mqNabHSVSYN3ECYm9Ss/adBCjK6ykMb0QUlc=")
    @GET("places/{fsq_id}")
    suspend fun getDescription(
        @Path("fsq_id") fsq_id: String,
    ): DescriptionResponse

    @Headers("Authorization:fsq3vLSgyS1mqNabHSVSYN3ECYm9Ss/adBCjK6ykMb0QUlc=")
    @GET("places/{fsq_id}/photos")
    suspend fun getPhoto(
        @Path("fsq_id") fsq_id: String,
    ): List<PhotoResponse>

}