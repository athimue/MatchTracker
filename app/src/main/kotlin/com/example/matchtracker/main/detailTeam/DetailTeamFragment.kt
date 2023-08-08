package com.example.matchtracker.main.detailTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.example.matchtracker.AppBarType
import com.example.matchtracker.NavigationType
import com.example.matchtracker.app.databinding.FragmentDetailTeamBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.example.matchtracker.common.fragment.AppBarFragment
import com.example.matchtracker.domain.game.models.Favorite
import com.example.matchtracker.domain.game.models.Team
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailTeamFragment : AppBarFragment(), DetailTeamPresenter {

    private val team: Team by lazy {
        val args = DetailTeamFragmentArgs.fromBundle(requireArguments())
        args.team
    }

    private val viewModel: DetailTeamViewModel by viewModels()

    private var _binding: FragmentDetailTeamBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailTeamBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getUiModel(team).collect {
                    binding.uiModel = it
                }
            }
        }
        binding.presenter = this
        binding.logo.load(team.logo)
        initToolbar()
        return binding.root
    }

    private fun initToolbar() {
        appBarListener?.setType(AppBarType.TOOLBAR)
        appBarListener?.setTitle("TEAM DETAIL")
        appBarListener?.setNavigationToolbar(NavigationType.ON_BACK)
    }

    override fun addFavorite() {
        viewModel.addFavorite(Favorite(team.id, team.name, team.logo))
    }

    override fun deleteFavorite() {
        viewModel.deleteFavorite(team.id)
    }
}