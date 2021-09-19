package com.udacity.shoestore

import androidx.databinding.BaseObservable
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>() // List of Shoe Class

    var shoeName = MutableLiveData<String>()
    var shoeCompany = MutableLiveData<String>()
    var shoeSize = MutableLiveData<String>()
    var shoeDesc = MutableLiveData<String>()

    val shoe : MutableLiveData<MutableList<Shoe>> get() = _shoes // return List of Shoe Class

    fun addShoe() {
        val addingShoe = Shoe(shoeName.toString(), shoeSize.toString(), shoeCompany.toString(),
            shoeDesc.toString())

        _shoes.value?.add(addingShoe)
    }



}