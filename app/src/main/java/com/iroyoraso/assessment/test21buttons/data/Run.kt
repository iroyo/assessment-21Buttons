package com.iroyoraso.assessment.test21buttons.data

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
data class Run(
    val id: String,
    val game: String,
    val times: Times,
    val videos: Video?,
    val comment: String?,
    val players: List<Player>
)