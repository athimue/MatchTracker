package com.example.matchtracker.main.search

import androidx.databinding.BaseObservable
import com.example.matchtracker.domain.game.models.Team

class SearchUiModel : BaseObservable() {

    var hasChanged: Boolean = false

    var teams = listOf<Team>()
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }
}