package com.iroyoraso.assessment.test21buttons.ui.list

import com.iroyoraso.assessment.test21buttons.core.Action
import com.iroyoraso.assessment.test21buttons.data.Game

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
interface ListViewModelInjector {

    fun loadGamesAction() : Action<Int, List<Game>>

    // HERE WE COULD ADD MORE ACTIONS IF NEEDED

}