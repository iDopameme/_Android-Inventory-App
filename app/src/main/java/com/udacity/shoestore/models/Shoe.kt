package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: String,
    var company: String,
    var description: String,
    //val images: List<String> = mutableListOf() -- No images yet--
) : Parcelable

