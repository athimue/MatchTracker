package com.example.matchtracker.data.repository

import com.example.matchtracker.data.database.dao.FavoriteDao
import com.example.matchtracker.data.database.entity.FavoriteEntity
import com.example.matchtracker.data.database.entity.toFavoriteEntity
import com.example.matchtracker.domain.game.models.Favorite
import com.example.matchtracker.domain.game.repo.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
) : FavoriteRepository {

    override suspend fun addFavorite(favorite: Favorite) {
        favoriteDao.insert(favorite.toFavoriteEntity())
    }

    override suspend fun deleteFavorite(teamId: Int) {
        favoriteDao.delete(teamId)
    }

    override fun isFavorite(teamId: Int): Flow<Favorite?> =
        favoriteDao.isFavorite(teamId).map { favorite -> favorite?.toFavorite() }

    override fun getFavorites(): Flow<List<Favorite>> =
        favoriteDao.getFavorites().map { list -> list.map(FavoriteEntity::toFavorite) }
}