package com.example.matchtracker.main.detailMatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.matchtracker.AppBarType
import com.example.matchtracker.NavigationType
import com.example.matchtracker.app.databinding.FragmentDetailMatchBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.example.matchtracker.common.fragment.AppBarFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMatchFragment : AppBarFragment() {

    private val mDetailMatchUiModel: DetailMatchUiModel by lazy {
        val args = DetailMatchFragmentArgs.fromBundle(requireArguments())
        args.gameUiModel
    }

    private val viewModel: DetailMatchViewModel by viewModels()

    private var _binding: FragmentDetailMatchBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailMatchBinding.inflate(inflater, container, false)
        binding.uiModel = mDetailMatchUiModel
        binding.teamHomeLogo.load(mDetailMatchUiModel.game.shortTeams?.home?.logo)
        binding.teamAwayLogo.load(mDetailMatchUiModel.game.shortTeams?.away?.logo)
        binding.score.text =
            mDetailMatchUiModel.game.scores?.home + " - " + mDetailMatchUiModel.game.scores?.away
        initToolbar()
        return binding.root
    }

    private fun initToolbar() {
        appBarListener?.setType(AppBarType.TOOLBAR)
        appBarListener?.setTitle("MATCH")
        appBarListener?.setNavigationToolbar(NavigationType.ON_BACK)
    }
}