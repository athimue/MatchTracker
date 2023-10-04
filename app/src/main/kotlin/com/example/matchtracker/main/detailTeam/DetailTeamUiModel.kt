package com.example.matchtracker.main.detailTeam

import androidx.databinding.BaseObservable
import com.example.matchtracker.domain.game.models.Game
import com.example.matchtracker.domain.game.models.Team

class DetailTeamUiModel(
    team: Team,
    teamsGames: List<Game>,
    isFavorite: Boolean
) : BaseObservable() {

    private var hasChanged: Boolean = false

    var isFavorite: Boolean = isFavorite
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }

    var team: Team? = team
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }

    var teamGames = teamsGames
        set(value) {
            if (field != value) {
                field = value
                hasChanged = true
                notifyChange()
            }
        }
}