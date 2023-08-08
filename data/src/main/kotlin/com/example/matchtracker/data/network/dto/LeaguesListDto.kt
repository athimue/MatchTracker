package com.example.matchtracker.data.network.dto

import com.google.gson.annotations.SerializedName

data class LeaguesListDto(
    @SerializedName("response") val response: List<LeagueDto>,
)