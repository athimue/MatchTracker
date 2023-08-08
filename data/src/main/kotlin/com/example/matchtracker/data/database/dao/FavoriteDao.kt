package com.example.matchtracker.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.matchtracker.data.database.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insert(favorite: FavoriteEntity): Long

    @Query("DELETE FROM favorites WHERE id IS :teamId")
    abstract suspend fun delete(teamId: Int): Int

    @Query("SELECT * FROM favorites WHERE id is :teamId ORDER BY id DESC")
    abstract fun isFavorite(teamId: Int): Flow<FavoriteEntity?>

    @Query("SELECT * FROM favorites ORDER BY id DESC")
    abstract fun getFavorites(): Flow<List<FavoriteEntity>>
}