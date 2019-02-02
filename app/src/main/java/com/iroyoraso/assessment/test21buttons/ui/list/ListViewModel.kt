package com.iroyoraso.assessment.test21buttons.ui.list

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.data.Game

class ListViewModel(injector: ListViewModelInjector) : ViewModel() {

    // DEPENDENCIES
    private val action = injector.loadGamesAction()

    // STATE
    private var offset = 0;

    fun retrieveData(listener: (List<GameData>) -> Unit) {
        action.performWith(offset) {
            offset = it.offset + it.size
            listener(it.games)
        }
    }

    override fun onCleared() {
        Log.d("IROYO", "HOLA")
        super.onCleared()
    }
}
