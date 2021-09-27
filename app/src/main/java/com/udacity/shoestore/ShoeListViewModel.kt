package com.udacity.shoestore
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val shoes = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<List<Shoe>>() // List of Shoe Class
    val navigateToListingScreen = MutableLiveData<Boolean>()
    val shoe : LiveData<List<Shoe>> get() = _shoes // return List of Shoe Class

    init {
        //defaultList()
    }

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        _shoes.value = shoes
        navigateToListingScreen.value = true
    }

    private fun defaultList() {
        val shoe1 = Shoe("Jordan", "10", "Nike", "Black")
        _shoes.value = mutableListOf(shoe1)
    }
}