package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeStoreViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeStoreViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)

        Timber.i("Called ViewModelProvider()")
        viewModel = ViewModelProvider(this).get(ShoeStoreViewModel::class.java)
        var shoe1 = Shoe("boat shoe",12.0, "Crocs", "wear on a boat")
        Timber.i("shoe1 is: $shoe1")
        // Inflate the layout for this fragment
        return binding.root
    }
}