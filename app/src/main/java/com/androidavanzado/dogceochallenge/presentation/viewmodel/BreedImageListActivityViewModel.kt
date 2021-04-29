package com.androidavanzado.dogceochallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.androidavanzado.dogceochallenge.data.repository.BreedImageRepository

class BreedImageListActivityViewModel(private val breedImageRepository: BreedImageRepository) : ViewModel() {

    var breedListData = breedImageRepository.liveData

    fun getData(breedName: String) {
        breedImageRepository.getData(breedName)
    }

}