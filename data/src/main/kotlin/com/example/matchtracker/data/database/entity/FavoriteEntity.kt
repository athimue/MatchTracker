package com.example.matchtracker.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.matchtracker.domain.game.models.Favorite

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val logo: String?
) {
    fun toFavorite(): Favorite = Favorite(
        id = id,
        name = name,
        logo = logo
    )
}

fun Favorite.toFavoriteEntity(): FavoriteEntity =
    FavoriteEntity(id = id, name = name, logo = logo)