package com.iroyoraso.assessment.test21buttons.ui.detail.presentation

import com.iroyoraso.assessment.test21buttons.core.Action
import com.iroyoraso.assessment.test21buttons.core.entities.ListData
import com.iroyoraso.assessment.test21buttons.core.entities.RunData
import com.iroyoraso.assessment.test21buttons.core.entities.UserData

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
interface InfoDetailViewModelInjector {

    fun loadRuns() : Action<String, ListData<RunData>>

    fun loadUser() : Action<String, UserData>

}