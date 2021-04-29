package com.androidavanzado.dogceochallenge.di

import com.androidavanzado.dogceochallenge.data.mappers.BreedImageNetworkMapper
import com.androidavanzado.dogceochallenge.data.mappers.BreedNameNetworkMapper
import com.androidavanzado.dogceochallenge.data.repository.BreedImageRepository
import com.androidavanzado.dogceochallenge.data.repository.BreedNameRepository

object Injection {

    private val breedNameNetworkMapper = BreedNameNetworkMapper()
    private val breedNameRepository = BreedNameRepository(breedNameNetworkMapper)
    fun providerBreedNameRepository() = breedNameRepository

    private val breedImageNetworkMapper = BreedImageNetworkMapper()
    private val breedImageRepository = BreedImageRepository(breedImageNetworkMapper)
    fun providerBreedImageRepository() = breedImageRepository
}