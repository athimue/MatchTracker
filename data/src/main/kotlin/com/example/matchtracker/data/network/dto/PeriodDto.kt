package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Period
import com.google.gson.annotations.SerializedName

class PeriodDto(
    @SerializedName("home") val home: String?,
    @SerializedName("away") val away: String?,
)

fun PeriodDto.toPeriod(): Period {
    return Period(
        home,
        away
    )
}