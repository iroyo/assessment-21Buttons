package com.iroyoraso.assessment.test21buttons.ui.list.presentation

import android.arch.lifecycle.ViewModel
import com.iroyoraso.assessment.test21buttons.core.entities.GameData

class ListViewModel(injector: ListViewModelInjector) : ViewModel() {

    // DEPENDENCIES
    private val loadGames = injector.loadGamesAction()

    // STATE
    private var offset = 0
    private var list = ArrayList<GameData>()

    fun initialData(
        listener: (List<GameData>) -> Unit,
        onError: () -> Unit
    ) {
        if (list.isNotEmpty()) {
            listener(list)
        } else {
            retrieveData(listener, onError)
        }
    }

    fun retrieveData(
        listener: (List<GameData>) -> Unit,
        onError: () -> Unit
    ) {
        loadGames.performWith(offset,
            success = {
                offset = it.offset + it.size
                list.addAll(it.list)
                listener(it.list)
            },
            failure = {
                // HERE WE SHOULD HANDLE EACH EXCEPTION
                onError()
            }
        )
    }

}
