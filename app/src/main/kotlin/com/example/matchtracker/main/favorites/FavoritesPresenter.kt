package com.example.matchtracker.main.favorites

import com.example.matchtracker.domain.game.models.Favorite

interface FavoritesPresenter {
    val deleteFavoriteCallback: (favorite: Favorite) -> Unit
}