package com.example.matchtracker.domain.game.models

data class Season(
    var current: Boolean,
    var end: String?,
    var season: Int?,
    var start: String,
)