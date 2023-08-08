package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

data class Scores(
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

    companion object CREATOR : Parcelable.Creator<Scores> {
        override fun createFromParcel(parcel: Parcel): Scores {
            return Scores(parcel)
        }

        override fun newArray(size: Int): Array<Scores?> {
            return arrayOfNulls(size)
        }
    }
}