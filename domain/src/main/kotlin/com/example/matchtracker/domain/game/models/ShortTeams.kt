package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

class ShortTeams(
    var home: ShortTeam?,
    var away: ShortTeam?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(ShortTeam::class.java.classLoader),
        parcel.readParcelable(ShortTeam::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(home, flags)
        parcel.writeParcelable(away, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShortTeams> {
        override fun createFromParcel(parcel: Parcel): ShortTeams {
            return ShortTeams(parcel)
        }

        override fun newArray(size: Int): Array<ShortTeams?> {
            return arrayOfNulls(size)
        }
    }
}