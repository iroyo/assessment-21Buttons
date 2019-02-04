package com.iroyoraso.assessment.test21buttons.testing

import com.iroyoraso.assessment.test21buttons.core.Action
import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.core.entities.ListData

/**
 * DOONAMIS
 * Created by iroyo on 04/02/2019.
 */
class MockLoadGame : Action<Int, ListData<GameData>> {

    override fun performWith(input: Int, success: (ListData<GameData>) -> Unit, failure: (Throwable) -> Unit) {
        success(createList())
    }

    private fun createList() : ListData<GameData> {
        val list = listOf(
            GameData("12345", "Test 1", "https://www.speedrun.com/themes/fishy/cover-128.png", "https://www.speedrun.com/themes/fishy/cover-128.png", "https://www.speedrun.com/themes/fishy/cover-128.png"),
            GameData("54321", "Test 2", "https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-128.png", "https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-128.png", "https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-128.png"),
            GameData("67890", "Test 3", "", "", ""),
            GameData("09876", "Test 4", "", "", "")
        )
        return ListData(0, list.size, list)
    }

}