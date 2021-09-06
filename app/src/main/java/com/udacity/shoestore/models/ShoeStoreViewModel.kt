package com.udacity.shoestore.models

import android.widget.Toast
import android.widget.Toast.makeText
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
    //private val _dataTransfer = MutableLiveData<Boolean>()
    // Per mentor suggestion, I am giving _dataTransfer an initial value of false
    private val _dataTransfer = MutableLiveData<Boolean>(false)
    val dataTransfer: LiveData<Boolean>
        get() = _dataTransfer


    init {
        _shoeListLiveData.value = ArrayList<Shoe>()
        _dataTransfer.value = false
    }

    // Adds Shoe object to shoeListLiveData
    fun onSave(shoe: Shoe) {
        _dataTransfer.value = true
        _shoeListLiveData.value?.add(shoe)
        Timber.i("Shoe added: ${shoe.name}")
    }

    fun onComplete() {
        _dataTransfer.value = false
    }
}