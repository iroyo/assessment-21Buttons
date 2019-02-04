package com.iroyoraso.assessment.test21buttons.ui.commons

import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */

fun ImageView.setImageFromNetwork(value: String?) {
    if (!value.isNullOrEmpty()) {
        Picasso.get().load(value).into(this)
    } else {
        setImageResource(0);
    }
}

fun TextView.setTextFromNetwork(value: String?) {
    if (value != null) {
        text = value.trim()
    }
}