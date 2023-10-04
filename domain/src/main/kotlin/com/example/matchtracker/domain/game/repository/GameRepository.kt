package com.example.matchtracker.domain.game.repository

import com.example.matchtracker.domain.game.models.Game
import com.example.matchtracker.domain.game.models.League
import com.example.matchtracker.domain.game.models.Team
import com.example.matchtracker.domain.game.util.Resource
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun getDayGames(date: String): Flow<Resource<List<Game>>>

    suspend fun getTeams(name: String?): Flow<Resource<List<Team>>>

    suspend fun getTeamGames(idTeam: Int): Flow<Resource<List<Game>>>

    suspend fun getLeagues(): Flow<Resource<List<League>>>
}