package com.example.matchtracker.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.matchtracker.app.databinding.ItemSportDropdownBinding

class SportSpinnerAdapter(
    private val context: Context,
    private val list: List<String>,
) : BaseAdapter() {

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int): Long = list[position].hashCode().toLong()

    override fun getCount(): Int = list.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return convertView ?: run {
            return ItemSportDropdownBinding.inflate(LayoutInflater.from(context), parent, false)
                .apply {
                    sport = getItem(position)
                }.root
        }
    }
}
