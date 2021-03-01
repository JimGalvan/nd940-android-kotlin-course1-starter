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

    private var _shoeInListState = MutableLiveData<Boolean>()
    val shoeInListState: LiveData<Boolean>
        get() = _shoeInListState

    private val _shoeSaved = MutableLiveData<Boolean>()
    val shoeSaved: LiveData<Boolean>
        get() = _shoeSaved

    init {
        _navigateToDetailsState.value = false
        _shoeInListState.value = false

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

    fun addShoeToList(shoe: Shoe) {
        shoeList.value?.add(shoe)
        _shoeSaved.value = true
    }

    fun setShoeInListStateToFalse() {
        _shoeInListState.value = false
    }
    /*
    We can use other optimal methods here such as BroadcastChannel, but that would require some more changes.
    */
    fun onShoeSaved() {
        _shoeSaved.value = false
    }
}