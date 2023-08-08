package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Team
import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("arena") val arena: ArenaDto,
    @SerializedName("country") val country: CountryDto,
    @SerializedName("founded") val founded: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("logo") val logo: String,
    @SerializedName("name") val name: String,
    @SerializedName("national") val national: Boolean,
)


fun TeamDto.toTeam(): Team {
    return Team(
        arena.toArena(),
        country.toCountry(),
        founded,
        id,
        logo,
        name,
        national
    )
}