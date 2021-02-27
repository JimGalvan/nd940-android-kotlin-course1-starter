package com.udacity.shoestore.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.shoe_list.ShoeListViewModel


class Details : Fragment() {

    var name: String = "none"
    var shoeSize: String = "0.0"
    var shoeCompany: String = "none"
    var shoeDescription: String = "none"

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(
            inflater, R.layout.fragment_details, container, false
        )

        ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel

        binding.saveNewShoe.setOnClickListener {
            name = binding.shoeNameInput.text.toString()
            shoeSize = binding.showSizeInput.text.toString()
            shoeCompany = binding.shoeCompanyInput.text.toString()
           shoeDescription= binding.shoeDescriptionInput.text.toString()

            shoeListViewModel.addShoeToList(name, shoeSize, shoeCompany, shoeDescription)
            findNavController().navigate(DetailsDirections.actionDetailsToShoeList2()
            )
        }

        binding.cancelNewShoeButton.setOnClickListener {
            findNavController().navigate(DetailsDirections.actionDetailsToShoeList2())
        }

        return binding.root
    }
}