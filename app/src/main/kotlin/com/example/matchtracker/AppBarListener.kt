package com.example.matchtracker

import android.view.MenuItem
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import com.google.android.material.bottomappbar.BottomAppBar

/**
 * Listener allows to work on toolbars.
 */
interface AppBarListener {

    fun setMenuBottomAppBar(@MenuRes resId: Int, onMenuItemClick: (MenuItem) -> Boolean)

    fun fabAlignmentMode(@BottomAppBar.FabAlignmentMode fabAlignmentMode: Int)

    fun setNavigationToolbar(type: NavigationType, onClick: ((View) -> Unit)? = null)

    fun setNavigationBottomAppBar(type: NavigationType)

    fun setFab(@DrawableRes resId: Int, onClick: (View) -> Unit)

    fun setType(type: AppBarType)

    fun setTitle(title: String)

    fun setTitle(resId: Int)
}

/**
 * AppBarType determines the toolbar to display.
 */
enum class AppBarType {
    BOTTOM_APP_BAR,
    TOOLBAR,
    ALL,
    NONE
}

/**
 * NavigationType determines the navigation action to be performed.
 */
enum class NavigationType {
    SLIDE_MENU,
    ON_BACK,
    NONE,
}
