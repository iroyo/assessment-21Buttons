package com.iroyoraso.assessment.test21buttons.ui.list.presentation

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.iroyoraso.assessment.test21buttons.core.entities.GameData

class ListViewModel(injector: ListViewModelInjector) : ViewModel() {

    // DEPENDENCIES
    private val action = injector.loadGamesAction()

    // STATE
    private var offset = 0

    fun initialData(listener: (List<GameData>) -> Unit) {
        retrieveData(listener)
    }

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
