package com.example.matchtracker.main.home

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.matchtracker.AppBarType
import com.example.matchtracker.NavigationType
import com.example.matchtracker.app.R
import com.example.matchtracker.app.databinding.FragmentHomeBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.example.matchtracker.common.fragment.AppBarFragment
import com.example.matchtracker.main.home.adapter.SportSpinnerAdapter
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class HomeFragment : AppBarFragment(), HomePresenter {

    private val viewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.presenter = this
        requireActivity()
        binding.navController = findNavController()
        binding.uiModel = viewModel.homeUiModel
        binding.sportSpinner.adapter = SportSpinnerAdapter(requireContext(), listOf("Rugby"))
        binding.sportSpinner.setSelection(0)
        initBottomAppBar()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        viewModel.refresh(dateFormat.format(Calendar.getInstance().time))
        return binding.root
    }

    private fun initBottomAppBar() {
        appBarListener?.setType(AppBarType.BOTTOM_APP_BAR)
        appBarListener?.fabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
        appBarListener?.setNavigationBottomAppBar(NavigationType.SLIDE_MENU)
        appBarListener?.setMenuBottomAppBar(R.menu.menu_home) { onMenuItemClick(it) }
        appBarListener?.setFab(R.drawable.ic_search) {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
        }
    }

    private fun onMenuItemClick(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_favorites -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFavoritesFragment())
            }
        }
        return true
    }

    override fun updateSport() {
        TODO("Not yet implemented")
    }

    override fun callDatePickerDialog(view: View) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(viewModel.homeUiModel.selectedDate)
        val calendar = Calendar.getInstance().apply {
            time = date!!
        }
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(), { _, year, month, dayOfMonth ->
                val selectedDateCalendar = Calendar.getInstance()
                selectedDateCalendar.set(year, month, dayOfMonth)
                viewModel.refresh(dateFormat.format(selectedDateCalendar.time))
            }, year, month, day
        )
        datePickerDialog.show()
    }
}
