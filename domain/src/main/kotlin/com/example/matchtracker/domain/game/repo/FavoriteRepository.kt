package com.example.matchtracker.domain.game.repo

import com.example.matchtracker.domain.game.models.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun addFavorite(favorite: Favorite)

    suspend fun deleteFavorite(teamId: Int)

    fun isFavorite(teamId: Int): Flow<Favorite?>

    fun getFavorites(): Flow<List<Favorite>>
}