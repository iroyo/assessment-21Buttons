package com.iroyoraso.assessment.test21buttons.core.entities

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
data class RunData(
    val id: String,
    val idPlayer: String?,
    val uriVideo: String?,
    val realTime: TimeStats?,
    val ingameTime: TimeStats?,
    val primaryTime: TimeStats?

)