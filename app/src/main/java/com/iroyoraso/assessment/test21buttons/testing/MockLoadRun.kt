package com.iroyoraso.assessment.test21buttons.testing

import com.iroyoraso.assessment.test21buttons.core.Action
import com.iroyoraso.assessment.test21buttons.core.entities.ListData
import com.iroyoraso.assessment.test21buttons.core.entities.RunData
import com.iroyoraso.assessment.test21buttons.core.entities.TimeStats

/**
 * DOONAMIS
 * Created by iroyo on 04/02/2019.
 */
class MockLoadRun : Action<Int, ListData<RunData>> {

    override fun performWith(input: Int, success: (ListData<RunData>) -> Unit, failure: (Throwable) -> Unit) {
        success(createList())
    }

    // FAKE DATA
    private fun createList() : ListData<RunData> {
        val list = listOf(
            RunData("12345", null, null, null, null, null), // no user, no vide, no stats
            RunData("12345", "qwerty", null, null, null, null), // no video
            RunData("12345", "qwerty", "uri", TimeStats(0, 50, 30), TimeStats(0, 40, 30), TimeStats(0, 40, 30)),
            RunData("12345", null, null, TimeStats(0, 50, 30), TimeStats(0, 50, 30), null)
        )
        return ListData(0, list.size, list)
    }

}