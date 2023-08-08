package com.example.matchtracker.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.matchtracker.app.databinding.ItemGamesBinding
import com.example.matchtracker.domain.game.models.Game
import com.example.matchtracker.main.detailMatch.DetailMatchUiModel
import com.example.matchtracker.main.home.HomeFragmentDirections
import java.text.SimpleDateFormat
import java.util.*

class GamesAdapter(
    private val games: List<Game>,
    private val navController: NavController?
) : ListAdapter<Game, GamesAdapter.ViewHolder>(GamesListDiffCallback()) {

    class ViewHolder(val binding: ItemGamesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val game = games[position]
            binding.firstTeam = game.shortTeams?.home?.name
            binding.secondTeam = game.shortTeams?.away?.name
            binding.firstTeamLogo.load(game.shortTeams?.home?.logo)
            binding.secondTeamLogo.load(game.shortTeams?.away?.logo)
            val dateFormat = SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault())
            binding.date = dateFormat.format(Date(game.timestamp * 1000))
            this.binding.executePendingBindings()
            this.binding.root.setOnClickListener {
                navController?.navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailMatchFragment(
                        DetailMatchUiModel(game)
                    )
                )
            }
        }

    }

    class GamesListDiffCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem == newItem
        }
    }
}
