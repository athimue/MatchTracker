package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable


class LongLeague(
    var id: Int,
    var name: String?,
    var type: String?,
    var logo: String?,
    var season: Int,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeString(logo)
        parcel.writeInt(season)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<League> {
        override fun createFromParcel(parcel: Parcel): League {
            return League(parcel)
        }

        override fun newArray(size: Int): Array<League?> {
            return arrayOfNulls(size)
        }
    }
}