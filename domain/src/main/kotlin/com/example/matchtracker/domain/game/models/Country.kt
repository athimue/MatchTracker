package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

class Country(
    var id: Int,
    var name: String?,
    var code: String?,
    var flag: String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(code)
        parcel.writeString(flag)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }
}