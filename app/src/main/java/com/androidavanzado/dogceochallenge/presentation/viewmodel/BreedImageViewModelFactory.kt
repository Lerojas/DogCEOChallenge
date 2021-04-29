package com.androidavanzado.dogceochallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidavanzado.dogceochallenge.data.repository.BreedImageRepository

@Suppress("UNCHECKED_CAST")
class BreedImageViewModelFactory
constructor(private val repository: BreedImageRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BreedImageListActivityViewModel(repository) as T
    }
}