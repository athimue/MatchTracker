package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Status
import com.google.gson.annotations.SerializedName

class StatusDto(
    @SerializedName("long") val long: String,
    @SerializedName("short") val short: String,
)

fun StatusDto.toStatus(): Status {
    return Status(
        long,
        short
    )
}