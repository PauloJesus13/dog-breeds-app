package com.pljesus.dogbreedsapp.domain.model

data class DogBreed(
    val id: Int,
    val name: String,
    val bredFor: String?,
    val breedGroup: String?,
    val lifeSpan: String?,
    val temperament: String?,
    val origin: String?,
    val referenceImageId: String?
)
