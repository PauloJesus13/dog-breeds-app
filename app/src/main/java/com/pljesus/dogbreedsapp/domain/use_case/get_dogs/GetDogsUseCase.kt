package com.pljesus.dogbreedsapp.domain.use_case.get_dogs

import com.pljesus.dogbreedsapp.common.Resource
import com.pljesus.dogbreedsapp.data.remote.dto.toDogBreed
import com.pljesus.dogbreedsapp.domain.model.DogBreed
import com.pljesus.dogbreedsapp.domain.repository.DogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(
    private val repository: DogRepository
) {

    operator fun invoke(): Flow<Resource<List<DogBreed>>> = flow {
        try {
            emit(Resource.Loading())
            val dogs = repository.getDogs().map { it.toDogBreed() }
            emit(Resource.Success(dogs))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, please check your internet connection."))
        }
    }
}