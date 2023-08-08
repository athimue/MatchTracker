package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Arena
import com.google.gson.annotations.SerializedName

class ArenaDto(
    @SerializedName("capacity") val capacity: Int,
    @SerializedName("location") val location: String,
    @SerializedName("name") val name: String,
)

fun ArenaDto.toArena(): Arena {
    return Arena(
        capacity,
        location,
        name
    )
}
