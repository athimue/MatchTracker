package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

data class Game(
    var id: Int,
    var date: String?,
    var time: String?,
    var timestamp: Long,
    var timezone: String?,
    var week: String?,
    var status: Status?,
    var country: Country?,
    var league: League?,
    var shortTeams: ShortTeams?,
    var scores: Scores?,
    var periods: Periods?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Status::class.java.classLoader),
        parcel.readParcelable(Country::class.java.classLoader),
        parcel.readParcelable(League::class.java.classLoader),
        parcel.readParcelable(ShortTeams::class.java.classLoader),
        parcel.readParcelable(Scores::class.java.classLoader),
        parcel.readParcelable(Periods::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeLong(timestamp)
        parcel.writeString(timezone)
        parcel.writeString(week)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Game> {
        override fun createFromParcel(parcel: Parcel): Game {
            return Game(parcel)
        }

        override fun newArray(size: Int): Array<Game?> {
            return arrayOfNulls(size)
        }
    }
}
