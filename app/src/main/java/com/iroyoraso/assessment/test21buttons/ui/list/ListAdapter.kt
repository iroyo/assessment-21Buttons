package com.iroyoraso.assessment.test21buttons.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.data.Game

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ListAdapter(private val list: List<Game>) : RecyclerView.Adapter<ListViewHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int) = ListViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_list_games, viewGroup, false
        )
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

    }

}