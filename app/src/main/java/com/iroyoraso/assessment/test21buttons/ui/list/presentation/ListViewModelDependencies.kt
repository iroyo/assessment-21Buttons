package com.iroyoraso.assessment.test21buttons.ui.list.presentation

import com.iroyoraso.assessment.test21buttons.core.LoadGames
import com.iroyoraso.assessment.test21buttons.net.ApiService
import com.iroyoraso.assessment.test21buttons.testing.MockLoadGame

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ListViewModelDependencies(private val api: ApiService) : ListViewModelInjector {

    override fun loadGamesAction() = LoadGames(api)
    //override fun loadGamesAction() = MockLoadGame() // TO TEST

}