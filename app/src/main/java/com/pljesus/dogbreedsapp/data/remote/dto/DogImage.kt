package com.pljesus.dogbreedsapp.data.remote.dto

import com.pljesus.dogbreedsapp.domain.model.DogBreed

data class DogImage(
    val id: String,
    val url: String,
    val breeds: DogBreed,
    val width: Int,
    val height: Int
)
