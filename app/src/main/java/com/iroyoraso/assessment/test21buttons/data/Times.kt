package com.iroyoraso.assessment.test21buttons.data

import com.google.gson.annotations.SerializedName

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
data class Times(
    val primary: String?,
    @SerializedName("primary_t")
    val primaryInMinutes: Int,
    val realtime: String?,
    @SerializedName("realtime_t")
    val realtimeInMinutes: Int,
    val ingame: String?,
    @SerializedName("ingame_t")
    val ingameInMinutes: Int
)