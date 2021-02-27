package com.udacity.shoestore.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.view.*

class Login : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.createAccountButton.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToWelcome2())
        }

        binding.continueExistingAccountButton.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToWelcome2())
        }
        return binding.root
    }
}