package com.example.matchtracker.main.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.matchtracker.AppBarType
import com.example.matchtracker.NavigationType
import com.example.matchtracker.app.databinding.FragmentLeaguesBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.example.matchtracker.common.fragment.AppBarFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeaguesFragment : AppBarFragment() {

    private val viewModel: LeaguesViewModel by viewModels()

    private var _binding: FragmentLeaguesBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaguesBinding.inflate(inflater, container, false)
        binding.uiModel = viewModel.leaguesUiModel
        initToolbar()
        return binding.root
    }

    private fun initToolbar() {
        appBarListener?.setType(AppBarType.TOOLBAR)
        appBarListener?.setTitle("Leagues")
        appBarListener?.setNavigationToolbar(NavigationType.ON_BACK)
    }
}