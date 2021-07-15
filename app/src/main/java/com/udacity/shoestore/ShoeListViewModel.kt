package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class ShoeListViewModel : ViewModel() {
    private var shoeName = ""
    private var shoeSize = 0

    private var result: MutableLiveData<String> = MutableLiveData()

    fun setShoes(n: String, s: Int) {
        this.shoeName = n
        this.shoeSize = s
    }

    fun getShoeName(): String {
        return shoeName
    }

    fun getShoeSize(): Int {
        return shoeSize
    }
}