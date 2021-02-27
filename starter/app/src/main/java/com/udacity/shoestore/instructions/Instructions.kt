package com.udacity.shoestore.instructions

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.models.Shoe

class Instructions : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding : FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions, container, false)

        binding.goToShoeListButton.setOnClickListener {
            findNavController().navigate(InstructionsDirections.actionInstructionsToShoeList2())
        }
        return binding.root
    }
}