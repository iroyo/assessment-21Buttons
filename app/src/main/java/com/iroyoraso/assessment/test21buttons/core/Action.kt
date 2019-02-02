package com.iroyoraso.assessment.test21buttons.core

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
interface Action<IN, OUT> {

    fun performWith(input: IN, callback: (OUT) -> Unit)

}