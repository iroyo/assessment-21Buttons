package com.iroyoraso.assessment.test21buttons.ui.detail.presentation

import android.arch.lifecycle.MutableLiveData
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

    fun retrieveRuns(gameId: String, listener: (RunData) -> Unit) {
        if (list.isNotEmpty()) {
            listener(list[0])
        } else {
            loadRuns.performWith(gameId) {
                list.addAll(it.list)
                listener(list[0])
            }
        }
    }

    fun getUser(userId: String, listener: (UserData) -> Unit) {
        loadUser.performWith(userId) { listener(it) }
    }

}