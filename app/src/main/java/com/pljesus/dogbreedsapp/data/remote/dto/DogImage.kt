package com.pljesus.dogbreedsapp.data.remote.dto

data class DogImage(
    val id: String,
    val url: String,
    val breeds: List<DogBreedDto>,
    val width: Int,
    val height: Int
)
