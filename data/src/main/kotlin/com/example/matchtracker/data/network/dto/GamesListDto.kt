package com.example.matchtracker.data.network.dto

import com.google.gson.annotations.SerializedName

data class GamesListDto(
    @SerializedName("response") val response: List<GameDto>,
)