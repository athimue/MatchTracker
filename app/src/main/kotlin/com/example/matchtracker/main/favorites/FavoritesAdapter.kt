package com.example.matchtracker.main.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.matchtracker.app.databinding.ItemTeamsBinding
import com.example.matchtracker.domain.game.models.Favorite

class FavoritesAdapter(
    private val favorites: List<Favorite>,
    private val deleteFavoriteCallback: ((favorite: Favorite) -> Unit)?
) : ListAdapter<Favorite, FavoritesAdapter.ViewHolder>(TeamListDiffCallback()) {

    class ViewHolder(val binding: ItemTeamsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTeamsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = favorites.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val favorite = favorites[position]
            binding.id = favorite.id
            binding.name = favorite.name
            binding.teamLogo.load(favorite.logo)
            binding.isFavoritePage = true
            binding.deleteBtn.setOnClickListener {
                deleteFavoriteCallback?.let { callback ->
                    callback(favorite)
                }
            }
            binding.executePendingBindings()
        }
    }

    class TeamListDiffCallback : DiffUtil.ItemCallback<Favorite>() {
        override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem == newItem
        }
    }
}
