package com.iroyoraso.assessment.test21buttons.core

import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.core.entities.GameDataList
import com.iroyoraso.assessment.test21buttons.data.Game
import com.iroyoraso.assessment.test21buttons.data.GameListResult
import com.iroyoraso.assessment.test21buttons.net.ApiService
import com.iroyoraso.assessment.test21buttons.net.Loader

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class LoadGames(private val api: ApiService) : Action<Int, GameDataList> {

    override fun performWith(input: Int, callback: (GameDataList) -> Unit) {
        api.getGames().enqueue(Loader<GameListResult>(
                success = {
                    val size = it.pagination.size
                    val offset = it.pagination.offset
                    val games = it.data.map { game -> transform(game) }
                    callback(GameDataList(size, offset, games))
                },
                failure = {

                }
        ))
    }

    private fun transform(game: Game) : GameData {
        var uriCoverGame : String? = null
        if (game.assets.coverMedium != null) {
            uriCoverGame = game.assets.coverMedium.uri
        }
        return GameData(
                game.id,
                game.names.international,
                uriCoverGame
        )
    }


}