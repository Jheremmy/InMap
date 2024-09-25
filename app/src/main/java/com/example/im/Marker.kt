package com.example.im

import android.os.Parcel
import android.os.Parcelable

data class Marker(val name: String, val description: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Marker> {
        override fun createFromParcel(parcel: Parcel): Marker {
            return Marker(parcel)
        }

        override fun newArray(size: Int): Array<Marker?> {
            return arrayOfNulls(size)
        }
    }
}