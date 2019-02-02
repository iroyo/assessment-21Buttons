package com.iroyoraso.assessment.test21buttons.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.iroyoraso.assessment.test21buttons.R

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val image: ImageView = view.findViewById(R.id.imageCover)
    val label: TextView = view.findViewById(R.id.textName)

}