package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Game
import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id") val id: Int,
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String,
    @SerializedName("timestamp") val timestamp: Long,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("week") val week: String?,
    @SerializedName("status") val status: StatusDto,
    @SerializedName("country") val country: CountryDto,
    @SerializedName("league") val league: LeagueDto,
    @SerializedName("teams") val teams: ShortTeamsDto,
    @SerializedName("scores") val scores: ScoresDto,
    @SerializedName("periods") val periods: PeriodsDto,
)

fun GameDto.toGame(): Game = Game(
    id,
    date,
    time,
    timestamp,
    timezone,
    week,
    status.toStatus(),
    country.toCountry(),
    league.toLeague(),
    teams.toTeams(),
    scores.toScores(),
    periods.toPeriods()
)