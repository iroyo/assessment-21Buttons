package com.iroyoraso.assessment.test21buttons.core.entities

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
data class ListData<T>(
        val size: Int,
        val offset: Int,
        val list: List<T>
)