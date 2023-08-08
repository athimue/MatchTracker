package com.example.matchtracker.data.network.dto

import com.google.gson.annotations.SerializedName

data class TeamsListDto(
    @SerializedName("response") val response: List<TeamDto>,
)