package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

class Period(
    var home: String?,
    var away: String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(home)
        parcel.writeString(away)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Period> {
        override fun createFromParcel(parcel: Parcel): Period {
            return Period(parcel)
        }

        override fun newArray(size: Int): Array<Period?> {
            return arrayOfNulls(size)
        }
    }
}