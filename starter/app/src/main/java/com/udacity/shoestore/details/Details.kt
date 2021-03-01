package com.udacity.shoestore.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoe_list.ShoeListViewModel


class Details : Fragment() {
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    private val shoeModel : Shoe = Shoe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(
            inflater, R.layout.fragment_details, container, false
        )
        binding.shoeModel = shoeModel
        binding.lifecycleOwner = this

        ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = shoeListViewModel

       shoeListViewModel.shoeSaved.observe(viewLifecycleOwner, Observer { isShoeSaved ->
            if(isShoeSaved) {
                findNavController().popBackStack()
                shoeListViewModel.onShoeSaved()
            }
        })

        binding.cancelNewShoeButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}