package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.ShoeStoreViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeStoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("Called ViewModelProvider()")
        viewModel = ViewModelProvider(this).get(ShoeStoreViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoe_detail, container, false)
    }

}