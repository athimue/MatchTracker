package com.example.matchtracker.data.di

import android.content.Context
import androidx.room.Room
import com.example.matchtracker.data.database.Database
import com.example.matchtracker.data.database.dao.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Singleton

/**
 * Object that groups the singletons of database.
 */
@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    /**
     * Creation of the Database instance.
     */
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): Database = runBlocking {
        val builder = Room.databaseBuilder(
            context,
            Database::class.java,
            Database.DATABASE_NAME
        )
        builder.enableMultiInstanceInvalidation()
        builder.build()
    }

    /**
     * Creation of the FavoriteDao instance.
     *
     * @param database instance of a database
     * @return FavoriteDao Dao of the table 'favorite'
     */
    @Singleton
    @Provides
    fun provideFavoriteDao(database: Database): FavoriteDao = database.favoriteDao()
}
