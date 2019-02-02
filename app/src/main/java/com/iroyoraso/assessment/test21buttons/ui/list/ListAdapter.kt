package com.iroyoraso.assessment.test21buttons.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.data.Game
import com.squareup.picasso.Picasso

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var list: List<Game> = ArrayList()

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int) = ListViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_list_games, viewGroup, false
        )
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = list[position]
        holder.label.text = item.names.international

        Picasso.get().load(item.assets.coverMedium?.uri).into(holder.image)
    }

    fun data(values: List<Game>) {
        list = values
        notifyDataSetChanged()
    }

}