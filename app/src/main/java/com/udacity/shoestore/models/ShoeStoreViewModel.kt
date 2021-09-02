package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {
    // List of shoes
    private val _shoeListLiveData = MutableLiveData<MutableList<Shoe>>()

    val shoeListLiveData: LiveData<MutableList<Shoe>>
        get() = _shoeListLiveData

    // Navigation event
    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate


    init {
        _shoeListLiveData.value = ArrayList<Shoe>()
        _eventNavigate.value = false
    }

    // Adds Shoe object to shoeListLiveData
    fun onSave(shoe: Shoe) {
        _eventNavigate.value = true
        _shoeListLiveData.value?.add(shoe)
    }

    fun onComplete() {
        _eventNavigate.value = false
    }
}