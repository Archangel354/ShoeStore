package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.databinding.ShoeListBinding
import com.udacity.shoestore.models.ShoeStoreViewModel


class ShoeListFragment : Fragment() { private val viewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        // Floating action button
        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        binding.shoeStoreViewModel = viewModel

        // Observes shoeListLiveData in SharedViewModel
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->

            // Loops through the shoeList and inflates each shoe
            for (shoe in shoeList) {
                val listItem = ShoeListBinding.inflate(layoutInflater, null, false)

                // Adds the user inputted values from shoe object
                listItem.shoe = shoe

                // Adds the inflated view to the linearlayoutListContainer
                binding.shoeListLinearLayout.addView(listItem.root)
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}

