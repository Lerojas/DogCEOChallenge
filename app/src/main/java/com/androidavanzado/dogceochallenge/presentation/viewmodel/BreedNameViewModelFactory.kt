package com.androidavanzado.dogceochallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidavanzado.dogceochallenge.data.repository.BreedNameRepository

@Suppress("UNCHECKED_CAST")
class BreedNameViewModelFactory
constructor(private val repository: BreedNameRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BreedNameListActivityViewModel(repository) as T
    }
}