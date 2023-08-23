package com.pljesus.dogbreedsapp.presentation.dog_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pljesus.dogbreedsapp.common.Resource
import com.pljesus.dogbreedsapp.domain.use_case.get_dogs.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DogListViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DogListState())
    val state: State<DogListState> = _state

    init {
        getDogs()
    }

    private fun getDogs() {
        getDogsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DogListState(dogs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        DogListState(error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = DogListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}