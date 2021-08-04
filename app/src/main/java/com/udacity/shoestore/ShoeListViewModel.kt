package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

// Primary Constructor is used
class ShoeListViewModel : ViewModel() {
    // Private variables
    private var shoeName = ""
    private var shoeSize = 0
    // Mutable Data (???)
    private var nameResult: MutableLiveData<String> = MutableLiveData()
    private var sizeResult: MutableLiveData<Int> = MutableLiveData()

    // Setter Shoe name
    fun setShoeName(value: String) {
        this.shoeName = value
        nameResult.value = value
    }

    // Setter Shoe size
    fun setShoeSize(value: Int) {
        this.shoeSize = value
        sizeResult.value = value
    }

    // Getter Shoe name
    fun getShoeName(): MutableLiveData<String> {
        return nameResult
    }

    // Getter Shoe size
    fun getShoeSize(): MutableLiveData<Int> {
        return sizeResult
    }
}