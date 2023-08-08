package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

class Teams(
    var home: Team?,
    var away: Team?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Team::class.java.classLoader),
        parcel.readParcelable(Team::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(home, flags)
        parcel.writeParcelable(away, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Teams> {
        override fun createFromParcel(parcel: Parcel): Teams {
            return Teams(parcel)
        }

        override fun newArray(size: Int): Array<Teams?> {
            return arrayOfNulls(size)
        }
    }
}