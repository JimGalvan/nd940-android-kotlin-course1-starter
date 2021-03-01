package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class Shoe(
    var name: String = "none",
    var size: Double = 0.0,
    var company: String = "none",
    var description: String = "none"
) : Parcelable {

    var sizeString: String
        get() = this.size.toString()
        set(value) {
            this.size = value.toDouble()
        }
}
