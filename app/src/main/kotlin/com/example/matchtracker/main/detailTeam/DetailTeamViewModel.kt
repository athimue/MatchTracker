package com.example.matchtracker.main.detailTeam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matchtracker.domain.game.models.Favorite
import com.example.matchtracker.domain.game.models.Team
import com.example.matchtracker.domain.game.repository.FavoriteRepository
import com.example.matchtracker.domain.game.repository.GameRepository
import com.example.matchtracker.domain.game.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class DetailTeamViewModel @Inject constructor(
    private val gameRepository: GameRepository, private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    suspend fun getUiModel(team: Team): Flow<DetailTeamUiModel> =
        gameRepository.getTeamGames(team.id).combine(favoriteRepository.isFavorite(team.id)) { teamGames, favorite ->
            when (teamGames) {
                is Resource.Loading, is Resource.Error -> {
                    DetailTeamUiModel(team, listOf(), false)
                }
                is Resource.Success -> {
                    DetailTeamUiModel(team, teamGames.data, favorite != null)
                }
            }
        }

    fun addFavorite(favorite: Favorite) {
        viewModelScope.launch {
            favoriteRepository.addFavorite(favorite)
        }
    }

    fun deleteFavorite(teamId: Int) {
        viewModelScope.launch {
            favoriteRepository.deleteFavorite(teamId)
        }
    }
}
