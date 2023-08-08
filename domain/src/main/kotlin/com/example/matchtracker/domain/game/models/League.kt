package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable


class League(
    var id: Int,
    var name: String?,
    var type: String?,
    var logo: String?,
    var season: Int?,
    var seasons: List<Season>?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        mutableListOf<Season>().apply {
            parcel.readList(this, Season::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeString(logo)
        season?.let { parcel.writeInt(it) }
        parcel.writeList(seasons)
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