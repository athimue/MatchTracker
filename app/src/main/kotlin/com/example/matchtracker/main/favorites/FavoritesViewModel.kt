package com.example.matchtracker.main.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matchtracker.domain.game.repo.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class FavoritesViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    val favoritesUiModel = FavoritesUiModel()

    init {
        viewModelScope.launch {
            favoriteRepository.getFavorites().collect {
                favoritesUiModel.favoriteTeams = it
            }
        }
    }

    fun deleteFavorite(teamId: Int) {
        viewModelScope.launch {
            favoriteRepository.deleteFavorite(teamId)
        }
    }
}
