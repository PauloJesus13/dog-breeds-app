package com.pljesus.dogbreedsapp.data.repository

import com.pljesus.dogbreedsapp.data.remote.DogApi
import com.pljesus.dogbreedsapp.data.remote.dto.DogBreedDto
import com.pljesus.dogbreedsapp.data.remote.dto.DogImage
import com.pljesus.dogbreedsapp.data.remote.dto.toDogBreed
import com.pljesus.dogbreedsapp.domain.model.DogBreed
import com.pljesus.dogbreedsapp.domain.repository.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val api: DogApi
) : DogRepository {
    override suspend fun getDogs(): List<DogBreedDto> {
        return api.getDogs()
    }

    override suspend fun getDogById(breedId: String): DogBreedDto {
        return api.getDogById(breedId)
    }

    override suspend fun getDogImages(breedId: String): List<DogImage> {
        val dogImagesDto: List<DogImage> = api.getDogImages(breedId)
        val dogBreedDto: DogBreedDto = api.getDogById(breedId)
        val dogBreed: DogBreed = dogBreedDto.toDogBreed()

        return dogImagesDto.map {
            DogImage(
                id = it.id,
                url = it.url,
                breeds = dogBreed, // Pass the single breed object
                width = it.width,
                height = it.height
            )
        }
    }
}