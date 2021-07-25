package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {
    init {
        Timber.i("ShoeStoreModel created!")
    }

    private val shoesList = mutableListOf<Shoe>()
    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    val shoeListLiveData: LiveData<List<Shoe>>
        get() = _shoeListLiveData

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeStoreViewModel destroyed!")
    }
}