package com.pljesus.dogbreedsapp.presentation

sealed class Screen(val route: String) {
    object DogListScreen: Screen("dog_list_screen")
    object DogDetailScreen: Screen("dog_detail_screen")
}
