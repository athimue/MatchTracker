package com.example.matchtracker.data.network.api

import com.example.matchtracker.data.network.dto.GamesListDto
import com.example.matchtracker.data.network.dto.LeaguesListDto
import com.example.matchtracker.data.network.dto.TeamsListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RugbyAPI {

    @GET("games")
    suspend fun getGames(@Query("date") date: String = "2023-09-23"): Response<GamesListDto>

    @GET("games")
    suspend fun getGames(
        @Query("team") teamId: Int,
        @Query("season") season: Int = 2023
    ): Response<GamesListDto>

    @GET("teams")
    suspend fun getTeams(@Query("country_id") countryId: Int = 7): Response<TeamsListDto>

    @GET("teams")
    suspend fun getTeams(
        @Query("name") name: String,
        @Query("country_id") countryId: Int = 7
    ): Response<TeamsListDto>

    @GET("leagues")
    suspend fun getLeagues(): Response<LeaguesListDto>

    companion object {
        const val BASE_URL = "https://api-rugby.p.rapidapi.com/"
    }
}
