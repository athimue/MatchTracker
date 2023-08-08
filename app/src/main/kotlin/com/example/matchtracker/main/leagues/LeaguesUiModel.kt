package com.example.matchtracker.main.leagues

import androidx.databinding.BaseObservable
import com.example.matchtracker.domain.game.models.League

class LeaguesUiModel : BaseObservable() {

    var hasChanged: Boolean = false

    var leagues = listOf<League>()
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }
}