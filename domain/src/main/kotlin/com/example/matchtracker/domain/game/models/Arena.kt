package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

class Arena(
    var capacity: Int,
    var location: String?,
    var name: String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(capacity)
        parcel.writeString(location)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Arena> {
        override fun createFromParcel(parcel: Parcel): Arena {
            return Arena(parcel)
        }

        override fun newArray(size: Int): Array<Arena?> {
            return arrayOfNulls(size)
        }
    }
}