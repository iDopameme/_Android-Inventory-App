package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import kotlin.random.Random

const val RESULT_KEY = "Shoe View"

// Primary Constructor is used
class ShoeListViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    // Private variables
    private var shoeName = ""
    private var shoeSize = ""
    // Mutable Data (???)
    private var result: MutableLiveData<String> = savedStateHandle.getLiveData(RESULT_KEY)

    // Set Shoe
    fun setShoe(name: String, size: String) {
        this.shoeName = name
        this.shoeSize = size
        val result = name + "\t" + size
        savedStateHandle.set(RESULT_KEY, result)
    }

    // Get Shoe
    fun getShoeName(): MutableLiveData<String> {
        return result
    }



    //    private fun getRandomShoe(): String {
//        shoeList = mutableListOf(
//            "Nike",
//            "Adidas",
//            "Puma",
//            "Under Armour",
//            "Reebok",
//            "Gucci",
//            "Prada",
//            "Polo"
//        )
//        shoeList.shuffle()
//
//        var s = shoeList[Random.nextInt(0, 7)]
//
//        return s
//    }
//
//    private fun getRandomSize(): Int {
//        return  Random.nextInt(4, 14)
//    }
}