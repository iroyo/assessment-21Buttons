package com.iroyoraso.assessment.test21buttons.ui.detail.presentation

import android.arch.lifecycle.ViewModel
import com.iroyoraso.assessment.test21buttons.core.entities.RunData
import com.iroyoraso.assessment.test21buttons.core.entities.UserData

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
class InfoDetailViewModel(injector: InfoDetailViewModelInjector) : ViewModel() {

    private val loadRuns = injector.loadRuns()
    private val loadUser = injector.loadUser()

    // STATE
    private var list = ArrayList<RunData>()

    fun retrieveRuns(
        gameId: String,
        onSuccess: (RunData) -> Unit,
        onError: () -> Unit
    ) {
        if (list.isNotEmpty()) {
            onSuccess(list[0])
        } else {
            loadRuns.performWith(gameId,
                success = {
                    list.addAll(it.list)
                    onSuccess(list[0])
                },
                failure = {
                    // HERE WE SHOULD HANDLE EACH EXCEPTION
                    onError()
                }
            )
        }
    }

    fun getUser(
        userId: String,
        onSuccess: (UserData) -> Unit,
        onError: () -> Unit
    ) {
        loadUser.performWith(userId,
            success = { onSuccess(it) },
            failure = { onError() })
    }

}