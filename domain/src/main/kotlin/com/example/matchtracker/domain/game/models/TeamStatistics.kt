package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

data class TeamStatistics(
    var country: Country?,
    var games: Int,
    var goals: String?,
    var league: String?,
    var team: Team?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Country::class.java.classLoader),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Team::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(country, flags)
        parcel.writeInt(games)
        parcel.writeString(goals)
        parcel.writeString(league)
        parcel.writeParcelable(team, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamStatistics> {
        override fun createFromParcel(parcel: Parcel): TeamStatistics {
            return TeamStatistics(parcel)
        }

        override fun newArray(size: Int): Array<TeamStatistics?> {
            return arrayOfNulls(size)
        }
    }
}
