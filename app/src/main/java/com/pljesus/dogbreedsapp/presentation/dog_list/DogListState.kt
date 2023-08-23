package com.pljesus.dogbreedsapp.presentation.dog_list

import com.pljesus.dogbreedsapp.domain.model.DogBreed

data class DogListState(
    val isLoading: Boolean = false,
    val dogs: List<DogBreed> = emptyList(),
    val error: String = ""
)