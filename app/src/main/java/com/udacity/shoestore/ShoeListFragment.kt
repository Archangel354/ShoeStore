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
        //val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        // Added more concise way of initializing the binding
        val binding = FragmentShoeListBinding.inflate(inflater,container,false)

        binding.shoeStoreViewModel = viewModel
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->

            for (shoe in shoeList) {
                val listItem = ShoeListBinding.inflate(layoutInflater, null, false)

                listItem.shoe = shoe

                binding.shoeListLinearLayout.addView(listItem.root)
            }
        })

        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        //findNavController().popBackStack()
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}

