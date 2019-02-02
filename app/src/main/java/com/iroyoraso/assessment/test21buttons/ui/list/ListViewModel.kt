package com.iroyoraso.assessment.test21buttons.ui.list

import android.arch.lifecycle.ViewModel
import android.util.Log

class ListViewModel(injector: ListViewModelInjector) : ViewModel() {

    // DEPENDENCIES
    private val action = injector.loadGamesAction()


    fun retrieveData() {
        action.performWith(input = 0) {
            Log.d("IROYO", "LOADED")
        }
    }

    override fun onCleared() {
        Log.d("IROYO", "HOLA")
        super.onCleared()
    }
}
