package com.example.matchtracker

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.MenuRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.matchtracker.app.R
import com.example.matchtracker.app.databinding.ActivityMainBinding
import com.example.matchtracker.common.extensions.getOrThrow
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AppBarListener {

    private var _binding: ActivityMainBinding? = null
    private val binding by lazy {
        _binding.getOrThrow()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupDrawerLayout()
        setupDrawerNavigation()
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupDrawerLayout() {
        val drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.home,
            R.string.action_settings
        )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun setupDrawerNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navigationView.setupWithNavController(navController)
    }

    override fun setMenuBottomAppBar(@MenuRes resId: Int, onMenuItemClick: (MenuItem) -> Boolean) {
        binding.bottomAppBar.menu.clear()
        binding.bottomAppBar.inflateMenu(resId)
        binding.bottomAppBar.setOnMenuItemClickListener(onMenuItemClick)
    }

    override fun fabAlignmentMode(fabAlignmentMode: Int) {
        binding.bottomAppBar.fabAlignmentMode = fabAlignmentMode
    }

    override fun setNavigationToolbar(type: NavigationType, onClick: ((View) -> Unit)?) {
        when (type) {
            NavigationType.SLIDE_MENU -> {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                binding.toolbar.setNavigationIcon(R.drawable.ic_menu_nav)
                binding.toolbar.setNavigationOnClickListener { toggleDrawer() }
            }
            NavigationType.ON_BACK -> {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                onClick?.let { binding.toolbar.setNavigationOnClickListener(it) } ?: kotlin.run {
                    binding.toolbar.setNavigationOnClickListener {
                        findNavController(R.id.navigation_host_fragment).navigateUp()
                    }
                }
            }
            NavigationType.NONE -> {
                binding.toolbar.setNavigationIcon(R.drawable.ic_bluetooth)
                binding.toolbar.navigationIcon?.alpha = 100
                binding.toolbar.setNavigationOnClickListener(null)
            }
        }
    }

    override fun setNavigationBottomAppBar(type: NavigationType) {
        when (type) {
            NavigationType.SLIDE_MENU -> {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                binding.bottomAppBar.setNavigationIcon(R.drawable.ic_menu_nav)
                binding.bottomAppBar.setNavigationOnClickListener { toggleDrawer() }
            }
            NavigationType.ON_BACK -> {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                binding.bottomAppBar.setNavigationIcon(R.drawable.ic_bluetooth)
                binding.bottomAppBar.setNavigationOnClickListener {
                    findNavController(R.id.navigation_view).navigateUp()
                }
            }
            NavigationType.NONE -> {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                binding.toolbar.navigationIcon = null
                binding.toolbar.setNavigationOnClickListener(null)
            }
        }
    }

    private fun toggleDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun setFab(resId: Int, onClick: (View) -> Unit) {
        binding.fab.setImageResource(resId)
        binding.fab.setOnClickListener(onClick)
        setFabEnable(true)
    }

    override fun setType(type: AppBarType) {
        when (type) {
            AppBarType.BOTTOM_APP_BAR -> {
                binding.toolbar.visibility = View.GONE
                setVisible(binding.bottomAppBar, true)
                setVisible(binding.toolbar, false)
            }
            AppBarType.TOOLBAR -> {
                setVisible(binding.bottomAppBar, false)
                setVisible(binding.toolbar, true)
            }
            AppBarType.NONE -> {
                setVisible(binding.bottomAppBar, false)
                setVisible(binding.toolbar, false)
            }
            AppBarType.ALL -> {
                setVisible(binding.bottomAppBar, true)
                setVisible(binding.toolbar, true)
            }
        }
    }

    private fun setFabEnable(enabled: Boolean) {
        binding.fab.isEnabled = enabled
    }

    override fun setTitle(resId: Int) {
        binding.toolbar.setTitle(resId)
    }

    override fun setTitle(title: String) {
        binding.toolbar.title = title
    }

    private fun setVisible(toolbar: Toolbar, isVisible: Boolean) {
        toolbar.isVisible = isVisible
        toolbar.menu.clear()
        if (toolbar is BottomAppBar) {
            binding.fab.isVisible = isVisible
        }
    }
}