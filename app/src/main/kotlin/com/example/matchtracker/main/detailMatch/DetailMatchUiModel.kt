package com.example.matchtracker.main.detailMatch

import android.os.Parcelable
import com.example.matchtracker.domain.game.models.Game
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
data class DetailMatchUiModel(
    @SerialName("game")
    val game: Game,
) : Parcelable {}