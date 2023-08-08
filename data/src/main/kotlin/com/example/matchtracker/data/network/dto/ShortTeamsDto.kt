package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.ShortTeams
import com.google.gson.annotations.SerializedName

class ShortTeamsDto(
    @SerializedName("home") val home: ShortTeamDto,
    @SerializedName("away") val away: ShortTeamDto,
)

fun ShortTeamsDto.toTeams(): ShortTeams {
    return ShortTeams(
        home.toTeam(),
        away.toTeam()
    )
}