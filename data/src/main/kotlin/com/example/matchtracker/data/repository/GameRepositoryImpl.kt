package com.example.matchtracker.data.repository

import com.example.matchtracker.data.network.api.RugbyAPI
import com.example.matchtracker.data.network.dto.*
import com.example.matchtracker.domain.game.models.Game
import com.example.matchtracker.domain.game.models.League
import com.example.matchtracker.domain.game.models.Team
import com.example.matchtracker.domain.game.repository.GameRepository
import com.example.matchtracker.domain.game.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val rugbyApi: RugbyAPI) : GameRepository {

    override suspend fun getDayGames(date: String): Flow<Resource<List<Game>>> {
        return flow {
            runCatching {
                emit(Resource.Loading)
                val response = rugbyApi.getGames(date)
                response.takeIf { it.isSuccessful }?.body()?.let {
                    val gameList = it.response.map(GameDto::toGame)
                    emit(Resource.Success(gameList))
                } ?: emit(Resource.Error("No data"))
            }.getOrElse {
                emit(Resource.Error(""))
            }
        }
    }

    override suspend fun getTeams(name: String?): Flow<Resource<List<Team>>> {
        return flow {
            runCatching {
                emit(Resource.Loading)
                val response = if (name != null) {
                    if (name != "") rugbyApi.getTeams(name) else rugbyApi.getTeams()
                } else rugbyApi.getTeams()
                response.takeIf { it.isSuccessful }?.body()?.let {
                    val teamList = it.response.map(TeamDto::toTeam)
                    emit(Resource.Success(teamList))
                } ?: emit(Resource.Error("No data"))
            }.getOrElse {
                emit(Resource.Error(""))
            }
        }
    }

    override suspend fun getTeamGames(idTeam: Int): Flow<Resource<List<Game>>> {
        return flow {
            runCatching {
                emit(Resource.Loading)
                val response = rugbyApi.getGames(idTeam)
                response.takeIf { it.isSuccessful }?.body()?.let {
                    val gameList = it.response.map(GameDto::toGame)
                    emit(Resource.Success(gameList))
                } ?: emit(Resource.Error("No data"))
            }.getOrElse {
                emit(Resource.Error(""))
            }
        }
    }

    override suspend fun getLeagues(): Flow<Resource<List<League>>> {
        return flow {
            runCatching {
                emit(Resource.Loading)
                val response = rugbyApi.getLeagues()
                response.takeIf { it.isSuccessful }?.body()?.let {
                    val gameList = it.response.map(LeagueDto::toLeague)
                    emit(Resource.Success(gameList))
                } ?: emit(Resource.Error("No data"))
            }.getOrElse {
                emit(Resource.Error(""))
            }
        }
    }
}