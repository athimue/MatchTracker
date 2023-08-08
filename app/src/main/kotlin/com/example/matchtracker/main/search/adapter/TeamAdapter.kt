package com.example.matchtracker.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.matchtracker.app.databinding.ItemTeamsBinding
import com.example.matchtracker.domain.game.models.Team
import com.example.matchtracker.main.search.SearchFragmentDirections

class TeamAdapter(
    private val teams: List<Team>,
    private val navController: NavController,
) : ListAdapter<Team, TeamAdapter.ViewHolder>(TeamListDiffCallback()) {

    class ViewHolder(val binding: ItemTeamsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTeamsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = teams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val team = teams[position]
            binding.name = team.name
            binding.id = team.id
            binding.teamLogo.load(team.logo)
            binding.isFavoritePage = false
            this.binding.executePendingBindings()
            this.binding.root.setOnClickListener {
                navController.navigate(
                    SearchFragmentDirections.actionSearchFragmentToDetailTeamFragment(
                        team
                    )
                )
            }
        }
    }

    class TeamListDiffCallback : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem == newItem
        }
    }
}
