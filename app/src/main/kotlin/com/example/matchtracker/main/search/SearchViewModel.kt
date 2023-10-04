package com.example.matchtracker.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matchtracker.domain.game.repository.GameRepository
import com.example.matchtracker.domain.game.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class SearchViewModel @Inject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    var uiModel = SearchUiModel()

    init {
        getData()
    }

    open fun refresh(name: String?) {
        getData(name)
    }

    private fun getData(name: String? = null) {
        viewModelScope.launch {
            gameRepository.getTeams(name).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        uiModel.teams = result.data
                    }
                    is Resource.Error, Resource.Loading -> {}
                }
            }
        }
    }
}