package com.androidavanzado.dogceochallenge.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidavanzado.dogceochallenge.data.repository.BreedNameRepository

class BreedNameListActivityViewModel (private val breedNameRepository: BreedNameRepository) : ViewModel() {

    var breedListData : MutableLiveData<ArrayList<String>?> = breedNameRepository.liveData

    fun getData() {
        breedNameRepository.getData()
    }
}