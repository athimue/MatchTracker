package com.example.matchtracker.common.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.matchtracker.AppBarListener

/**
 * A parent fragment for all fragments using [AppBarListener].
 */
open class AppBarFragment : Fragment() {

    protected var appBarListener: AppBarListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appBarListener = requireActivity() as? AppBarListener
    }

    override fun onDetach() {
        super.onDetach()
        appBarListener = null
    }
}
