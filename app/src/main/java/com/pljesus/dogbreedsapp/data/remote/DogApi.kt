package com.pljesus.dogbreedsapp.data.remote

import com.pljesus.dogbreedsapp.data.remote.dto.DogBreedDto
import com.pljesus.dogbreedsapp.data.remote.dto.DogImage
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("breeds")
    suspend fun getDogs(): List<DogBreedDto>

    @GET("breeds/{breedId}")
    suspend fun getDogById(@Path("breedId") breedId: String): DogBreedDto

    @GET("images/search?breed_id={breedId}")
    suspend fun getDogImages(@Path("breedId") breedId: String): List<DogImage>
}