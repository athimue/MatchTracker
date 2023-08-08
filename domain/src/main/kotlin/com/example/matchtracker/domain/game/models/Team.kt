package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

data class Team(
    var arena: Arena?,
    var country: Country?,
    var founded: Int?,
    var id: Int,
    var logo: String?,
    var name: String?,
    var national: Boolean?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Arena::class.java.classLoader),
        parcel.readParcelable(Country::class.java.classLoader),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readBoolean()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(arena, flags)
        parcel.writeParcelable(country, flags)
        founded?.let { parcel.writeInt(it) }
        parcel.writeInt(id)
        parcel.writeString(logo)
        parcel.writeString(name)
        national?.let { parcel.writeBoolean(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Team> {
        override fun createFromParcel(parcel: Parcel): Team {
            return Team(parcel)
        }

        override fun newArray(size: Int): Array<Team?> {
            return arrayOfNulls(size)
        }
    }
}
