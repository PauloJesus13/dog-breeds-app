package com.pljesus.dogbreedsapp.presentation.dog_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pljesus.dogbreedsapp.common.Constants
import com.pljesus.dogbreedsapp.common.Resource
import com.pljesus.dogbreedsapp.domain.use_case.get_dog.GetDogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DogDetailViewModel @Inject constructor(
    private val getDogUseCase: GetDogUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(DogDetailState())
    val state: State<DogDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_DOG_ID)?.let { dogId ->
            getDog(dogId)
        }
    }

    private fun getDog(dogId: String) {
        getDogUseCase(dogId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DogDetailState(dog = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        DogDetailState(error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = DogDetailState(isLoading = true)
                }
            }
        }
    }
}