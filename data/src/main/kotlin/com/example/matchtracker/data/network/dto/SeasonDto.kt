package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Season
import com.google.gson.annotations.SerializedName

data class SeasonDto(
    @SerializedName("current") val current: Boolean,
    @SerializedName("end") val end: String,
    @SerializedName("season") val season: Int,
    @SerializedName("start") val start: String
)

fun SeasonDto.toSeason(): Season = Season(
    current,
    end,
    season,
    start
)