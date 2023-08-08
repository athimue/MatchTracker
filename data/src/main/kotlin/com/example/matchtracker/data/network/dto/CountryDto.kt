package com.example.matchtracker.data.network.dto

import com.example.matchtracker.domain.game.models.Country
import com.google.gson.annotations.SerializedName

class CountryDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("code") val code: String?,
    @SerializedName("flag") val flag: String?,
)

fun CountryDto.toCountry(): Country {
    return Country(
        id,
        name,
        code,
        flag
    )
}