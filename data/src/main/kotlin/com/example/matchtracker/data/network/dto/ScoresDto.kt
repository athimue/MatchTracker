package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Scores
import com.google.gson.annotations.SerializedName

class ScoresDto(
    @SerializedName("home") val home: String?,
    @SerializedName("away") val away: String?,
)


fun ScoresDto.toScores(): Scores {
    return Scores(home, away)
}

