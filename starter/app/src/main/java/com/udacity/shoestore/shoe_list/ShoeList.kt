package com.udacity.shoestore.shoe_list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeBannerBinding


class ShoeList : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        binding.lifecycleOwner = this

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
                val shoeItemBinding = DataBindingUtil.inflate<ShoeBannerBinding>(inflater, R.layout.shoe_banner, container, false)
                shoeItemBinding.shoe = shoe
                binding.shoeListLinearLayout.addView(shoeItemBinding.root)
            }
        })

        shoeListViewModel.navigateToDetailsState.observe(
            viewLifecycleOwner,
            Observer { stateToNavigate ->
                if (stateToNavigate) {
                    findNavController().navigate(ShoeListDirections.actionShoeList2ToDetails())
                    shoeListViewModel.setNavigationStateToFalse()
                }
            })

        setHasOptionsMenu(true)

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}