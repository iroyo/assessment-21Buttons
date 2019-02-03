package com.iroyoraso.assessment.test21buttons.ui.list.screen

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.ui.commons.setImageFromNetwork
import com.iroyoraso.assessment.test21buttons.ui.commons.setTextFromNetwork

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ListAdapter(private val onItemClick: (View, GameData) -> Unit) : RecyclerView.Adapter<ListViewHolder>() {

    private var list = mutableListOf<GameData>()

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int) =
        ListViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.item_list_games, viewGroup, false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = list[position]

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.image.transitionName = item.id
        }

        holder.label.setTextFromNetwork(item.name)
        holder.image.setImageFromNetwork(item.coverMedium)
        holder.itemView.setOnClickListener { onItemClick(it, item) }
    }

    fun data(values: List<GameData>) {
        list.addAll(values)
        notifyDataSetChanged()
    }

}