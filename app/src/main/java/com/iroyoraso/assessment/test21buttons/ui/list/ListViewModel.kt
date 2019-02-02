package com.iroyoraso.assessment.test21buttons.ui.list

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.iroyoraso.assessment.test21buttons.data.Game

class ListViewModel(injector: ListViewModelInjector) : ViewModel() {

    // DEPENDENCIES
    private val action = injector.loadGamesAction()

    fun retrieveData(listener: (List<Game>) -> Unit) {
        action.performWith(input = 0) {
            Log.d("IROYO", "LOADED")
            listener(it)
        }
    }

    override fun onCleared() {
        Log.d("IROYO", "HOLA")
        super.onCleared()
    }
}
