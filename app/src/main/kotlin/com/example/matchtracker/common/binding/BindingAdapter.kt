package com.example.matchtracker.common.binding

import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.matchtracker.domain.game.models.Favorite
import com.example.matchtracker.domain.game.models.Game
import com.example.matchtracker.domain.game.models.Team
import com.example.matchtracker.main.favorites.FavoritesAdapter
import com.example.matchtracker.main.home.adapter.GamesAdapter
import com.example.matchtracker.main.search.SearchPresenter
import com.example.matchtracker.main.search.adapter.TeamAdapter

@BindingAdapter("games", "navController")
fun RecyclerView.setGamesAdapter(games: List<Game>?, navController: NavController?) {
    games?.let { adapter = GamesAdapter(games, navController) }
}

@BindingAdapter("teams", "navController")
fun RecyclerView.setTeamsAdapter(teams: List<Team>, navController: NavController) {
    adapter = TeamAdapter(teams, navController)
}

@BindingAdapter("favorites", "deleteFavoriteCallback")
fun RecyclerView.setFavoritesAdapter(
    favorite: List<Favorite>,
    deleteFavoriteCallback: ((favorite: Favorite) -> Unit)?
) {
    adapter = FavoritesAdapter(favorite, deleteFavoriteCallback)
}


@BindingAdapter("setQueryTextChange")
fun SearchView.setQueryTextChange(presenter: SearchPresenter) {
    setOnQueryTextListener(presenter)
}
