package com.example.matchtracker.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.matchtracker.AppBarType
import com.example.matchtracker.NavigationType
import com.example.matchtracker.app.R
import com.example.matchtracker.app.databinding.FragmentFavoritesBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.example.matchtracker.common.fragment.AppBarFragment
import com.example.matchtracker.domain.game.models.Favorite
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : AppBarFragment(), FavoritesPresenter {

    private val viewModel: FavoritesViewModel by viewModels()

    private var _binding: FragmentFavoritesBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        binding.uiModel = viewModel.favoritesUiModel
        binding.presenter = this
        initToolbar()
        return binding.root
    }

    private fun initToolbar() {
        appBarListener?.setType(AppBarType.TOOLBAR)
        appBarListener?.setTitle(R.string.favorites_teams)
        appBarListener?.setNavigationToolbar(NavigationType.ON_BACK)
    }

    override val deleteFavoriteCallback: (favorite: Favorite) -> Unit
        get() = {
            viewModel.deleteFavorite(it.id)
        }
}