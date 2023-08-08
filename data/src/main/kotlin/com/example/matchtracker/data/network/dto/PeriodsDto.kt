package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Periods
import com.google.gson.annotations.SerializedName

class PeriodsDto(
    @SerializedName("first") val first: PeriodDto,
    @SerializedName("second") val second: PeriodDto,
    @SerializedName("overtime") val overtime: PeriodDto,
    @SerializedName("second_overtime") val second_overtime: PeriodDto,
)

fun PeriodsDto.toPeriods(): Periods {
    return Periods(
        first.toPeriod(),
        second.toPeriod(),
        overtime.toPeriod(),
        second_overtime.toPeriod()
    )
}