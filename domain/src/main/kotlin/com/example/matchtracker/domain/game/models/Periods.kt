package com.example.matchtracker.domain.game.models

import android.os.Parcel
import android.os.Parcelable

class Periods(
    var first: Period?,
    var second: Period?,
    var overtime: Period?,
    var second_overtime: Period?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Period::class.java.classLoader),
        parcel.readParcelable(Period::class.java.classLoader),
        parcel.readParcelable(Period::class.java.classLoader),
        parcel.readParcelable(Period::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(first, flags)
        parcel.writeParcelable(second, flags)
        parcel.writeParcelable(overtime, flags)
        parcel.writeParcelable(second_overtime, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Periods> {
        override fun createFromParcel(parcel: Parcel): Periods {
            return Periods(parcel)
        }

        override fun newArray(size: Int): Array<Periods?> {
            return arrayOfNulls(size)
        }
    }
}