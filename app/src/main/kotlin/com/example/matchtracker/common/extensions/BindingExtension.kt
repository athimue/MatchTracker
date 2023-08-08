package com.example.matchtracker.common.extensions

import androidx.viewbinding.ViewBinding

/**
 * Extension that returns a non-nullable binding.
 */
inline fun <reified T : ViewBinding> T?.getOrThrow(): T =
    checkNotNull(this) { "ViewBinding ${T::class} has been used outside view's lifecycle" }

