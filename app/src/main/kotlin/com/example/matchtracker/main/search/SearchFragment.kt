package com.example.matchtracker.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.matchtracker.AppBarType
import com.example.matchtracker.NavigationType
import com.example.matchtracker.app.databinding.FragmentSearchBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.example.matchtracker.common.fragment.AppBarFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : AppBarFragment(), SearchPresenter {

    private val viewModel: SearchViewModel by viewModels()
    private var searchJob: Job? = null

    private var _binding: FragmentSearchBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.presenter = this
        binding.uiModel = viewModel.uiModel
        binding.navController = findNavController()
        initToolbar()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        searchJob?.cancel()
    }

    private fun initToolbar() {
        appBarListener?.setType(AppBarType.TOOLBAR)
        appBarListener?.setTitle("RECHERCHE")
        appBarListener?.setNavigationToolbar(NavigationType.ON_BACK)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            delay(300)
            viewModel.refresh(newText)
        }
        return true
    }
}