package com.pljesus.dogbreedsapp.di

import com.pljesus.dogbreedsapp.common.Constants
import com.pljesus.dogbreedsapp.data.remote.DogApi
import com.pljesus.dogbreedsapp.data.repository.DogRepositoryImpl
import com.pljesus.dogbreedsapp.domain.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDogApi(): DogApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDogRepository(api: DogApi): DogRepository {
        return DogRepositoryImpl(api)
    }
}