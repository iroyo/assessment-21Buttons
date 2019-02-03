package com.iroyoraso.assessment.test21buttons.ui.detail.presentation

import com.iroyoraso.assessment.test21buttons.core.LoadRuns
import com.iroyoraso.assessment.test21buttons.core.LoadUser
import com.iroyoraso.assessment.test21buttons.net.ApiService

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
class InfoDetailViewModelDependencies(private val api: ApiService) : InfoDetailViewModelInjector {

    override fun loadUser() = LoadUser(api)

    override fun loadRuns() = LoadRuns(api)

}