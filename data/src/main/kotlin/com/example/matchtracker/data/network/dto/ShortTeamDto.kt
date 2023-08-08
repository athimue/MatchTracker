package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.ShortTeam
import com.google.gson.annotations.SerializedName

class ShortTeamDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("logo") val logo: String,
)


fun ShortTeamDto.toTeam(): ShortTeam {
    return ShortTeam(
        id,
        name,
        logo
    )
}