package com.example.matchtracker.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matchtracker.domain.game.repository.GameRepository
import com.example.matchtracker.domain.game.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class HomeViewModel @Inject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    var homeUiModel = HomeUiModel()

    open fun refresh(date: String) {
        homeUiModel.selectedDate = date
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            gameRepository.getDayGames(homeUiModel.selectedDate).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        homeUiModel.isLoading = true
                        homeUiModel.matchSport = listOf()
                    }
                    is Resource.Error -> {
                        homeUiModel.isLoading = false
                        homeUiModel.matchCount = "-1"
                        homeUiModel.matchSport = listOf()
                        cancel()
                    }
                    is Resource.Success -> {
                        homeUiModel.isLoading = false
                        homeUiModel.matchSport = result.data
                        homeUiModel.matchCount = result.data.size.toString()
                        cancel()
                    }
                }
            }
        }
    }
}
