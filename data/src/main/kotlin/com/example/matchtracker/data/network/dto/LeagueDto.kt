package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.League
import com.google.gson.annotations.SerializedName

class LeagueDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("season") val season: Int?,
    @SerializedName("seasons") val seasons: List<SeasonDto>?,
)

fun LeagueDto.toLeague(): League {
    return League(
        id,
        name,
        type,
        logo,
        season,
        seasons?.map(SeasonDto::toSeason)
    )
}
