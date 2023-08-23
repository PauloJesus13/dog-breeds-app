package com.pljesus.dogbreedsapp.presentation.dog_detail

import com.pljesus.dogbreedsapp.domain.model.DogBreed

data class DogDetailState(
    val isLoading: Boolean = false,
    val dog: DogBreed? = null,
    val error: String = ""
)
