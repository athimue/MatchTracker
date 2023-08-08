package com.example.matchtracker.main.favorites

import androidx.databinding.BaseObservable
import com.example.matchtracker.domain.game.models.Favorite

class FavoritesUiModel : BaseObservable() {

    var hasChanged: Boolean = false

    var favoriteTeams = listOf<Favorite>()
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }
}