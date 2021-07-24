package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {
    init {
        Timber.i("ShoeStoreModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeStoreViewModel destroyed!")
    }
}