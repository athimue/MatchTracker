package com.example.matchtracker.main.home

import androidx.databinding.BaseObservable
import com.example.matchtracker.domain.game.models.Game

class HomeUiModel : BaseObservable() {

    private var hasChanged: Boolean = false

    var selectedDate: String = "2023-09-23"
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }

    var isLoading: Boolean = true
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }

    var sportSelected: String = "RUGBY"
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }

    var matchCount: String = "0"
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }

    var matchSport = listOf<Game>()
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }
}
