package com.example.matchtracker.data.di

import com.example.matchtracker.data.repository.FavoriteRepositoryImpl
import com.example.matchtracker.data.repository.GameRepositoryImpl
import com.example.matchtracker.domain.game.repo.FavoriteRepository
import com.example.matchtracker.domain.game.repo.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Object that groups the singletons of repositories.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonModule {

    @Binds
    @Singleton
    abstract fun bindsGameRepository(gameRepositoryImpl: GameRepositoryImpl): GameRepository

    @Binds
    @Singleton
    abstract fun bindsFavoriteRepository(favoriteRepositoryImpl: FavoriteRepositoryImpl): FavoriteRepository
}
