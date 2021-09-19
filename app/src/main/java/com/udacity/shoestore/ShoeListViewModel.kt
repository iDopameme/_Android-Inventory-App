package com.udacity.shoestore
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>() // List of Shoe Class

    val shoe : MutableLiveData<MutableList<Shoe>> get() = _shoes // return List of Shoe Class

    fun addShoe(shoe: Shoe) {
        val newShoe = Shoe(shoe.name, shoe.size, shoe.company, shoe.description)

        _shoes.value?.add(newShoe)
    }
}