package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.SerialName

data class ShortTeam(
    @SerialName("id")
    var id : Int,
    @SerialName("name")
    var name: String?,
    @SerialName("logo")
    var logo: String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
        dest.writeString(logo)
    }

    companion object CREATOR : Parcelable.Creator<ShortTeam> {
        override fun createFromParcel(parcel: Parcel): ShortTeam {
            return ShortTeam(parcel)
        }

        override fun newArray(size: Int): Array<ShortTeam?> {
            return arrayOfNulls(size)
        }
    }
}