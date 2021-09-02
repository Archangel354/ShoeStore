package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeStoreViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflates the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        // Binds the XML
        binding.shoeStoreViewModel = viewModel
        binding.lifecycleOwner = this

        // Assigns default values to xml shoe variable
        binding.shoe = Shoe("", 0.0, "", "")


        viewModel.eventNavigate.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.onComplete()
                Toast.makeText(context, "Shoe Added", Toast.LENGTH_SHORT).show()
            }
        })

        // Cancel button
        binding.btnCancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        return binding.root

    }

}