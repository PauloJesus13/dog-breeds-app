package com.pljesus.dogbreedsapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.pljesus.dogbreedsapp.domain.model.DogBreed

data class DogBreedDto(
    val weight: Weight,
    val height: Height,
    val id: Int,
    val name: String,
    @SerializedName("bred_for")
    val bredFor: String?,
    @SerializedName("breed_group")
    val breedGroup: String?,
    @SerializedName("life_span")
    val lifeSpan: String?,
    val temperament: String?,
    val origin: String?,
    @SerializedName("reference_image_id")
    val referenceImageId: String?
)

fun DogBreedDto.toDogBreed(): DogBreed {
    return DogBreed(
        id = id,
        name = name,
        bredFor = bredFor,
        breedGroup = breedGroup,
        lifeSpan = lifeSpan,
        temperament = temperament,
        origin = origin,
        referenceImageId = referenceImageId
    )
}