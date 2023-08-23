package com.pljesus.dogbreedsapp.domain.repository

import com.pljesus.dogbreedsapp.data.remote.dto.DogBreedDto
import com.pljesus.dogbreedsapp.data.remote.dto.DogImage

interface DogRepository {
    suspend fun getDogs(): List<DogBreedDto>
    suspend fun getDogById(breedId: String): DogBreedDto
    suspend fun getDogImages(breedId: String): List<DogImage>
}