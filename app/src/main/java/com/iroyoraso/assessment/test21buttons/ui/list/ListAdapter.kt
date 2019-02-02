package com.iroyoraso.assessment.test21buttons.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.data.Game
import com.squareup.picasso.Picasso

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var list: MutableList<GameData> = arrayListOf()

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int) = ListViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_list_games, viewGroup, false
        )
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = list[position]
        holder.label.text = item.name

        Picasso.get().load(item.cover).into(holder.image)
    }

    fun data(values: List<GameData>) {
        list.addAll(values)
        notifyDataSetChanged()
    }

}