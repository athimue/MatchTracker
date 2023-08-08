package com.example.matchtracker.main.leagues

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matchtracker.domain.game.repository.GameRepository
import com.example.matchtracker.domain.game.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class LeaguesViewModel @Inject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    val leaguesUiModel = LeaguesUiModel()

    init {
        viewModelScope.launch {
            gameRepository.getLeagues().collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.d("COUCOU", "Loading")
                        leaguesUiModel.leagues = listOf()
                    }
                    is Resource.Error -> {
                        Log.d("COUCOU", "Error")
                        leaguesUiModel.leagues = listOf()
                        cancel()
                    }
                    is Resource.Success -> {
                        leaguesUiModel.leagues = it.data
                        Log.d("COUCOU", it.data.toString())
                        cancel()
                    }
                }
            }
        }
    }
}
