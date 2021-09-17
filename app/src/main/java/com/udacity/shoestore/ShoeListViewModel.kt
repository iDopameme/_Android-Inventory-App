package com.udacity.shoestore

import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe


class ShoeListViewModel : ViewModel() {
    private val shoes = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoe : LiveData<List<Shoe>> get() = _shoes

    fun setShoe(newShoe: Shoe) {
        shoes.add(newShoe)
        _shoes.value = shoes
    }

}