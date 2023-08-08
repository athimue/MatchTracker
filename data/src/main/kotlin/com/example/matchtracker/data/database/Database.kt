package com.example.matchtracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.matchtracker.data.database.dao.FavoriteDao
import com.example.matchtracker.data.database.entity.FavoriteEntity

/**
 * Class that defines the database room.
 */
@Database(
    entities = [
        FavoriteEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

    companion object {
        const val DATABASE_NAME: String = "database.db"
    }
}
