package com.udacity.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _navigateToDetailsState = MutableLiveData<Boolean>()
    val navigateToDetailsState: LiveData<Boolean>
        get() = _navigateToDetailsState

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _navigateToDetailsState.value = false

        _shoeList.value = mutableListOf(
            Shoe("Hustler", 6.0, "Adidas", "Sport shoes"),
            Shoe("Hackel", 7.0, "Adidas", "Summer shoes"),
            Shoe("Antidote", 7.0, "Salomon", "Exercise shoes"),
            Shoe("Lizard", 9.0, "Trickers", "Dressing shoes"),
            Shoe("Lizard", 9.0, "Trickers", "Dressing shoes"),
            Shoe("Lizard", 9.0, "Trickers", "Dressing shoes")
        )
    }

    fun navigateToDetailsScreen() {
        _navigateToDetailsState.value = true
    }

    fun setNavigationStateToFalse() {
        _navigateToDetailsState.value = false
    }

    fun addShoeToList(name: String, shoeSize: String, shoeCompany: String, shoeDescription: String) {
        shoeList.value?.add(Shoe(name, shoeSize.toDouble() , shoeCompany, shoeDescription))
    }
}