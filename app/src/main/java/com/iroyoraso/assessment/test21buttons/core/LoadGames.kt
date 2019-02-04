package com.iroyoraso.assessment.test21buttons.core

import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.core.entities.ListData
import com.iroyoraso.assessment.test21buttons.data.Game
import com.iroyoraso.assessment.test21buttons.data.ListResult
import com.iroyoraso.assessment.test21buttons.net.ApiService
import com.iroyoraso.assessment.test21buttons.net.Loader

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class LoadGames(private val api: ApiService) : Action<Int, ListData<GameData>> {

    override fun performWith(input: Int, success: (ListData<GameData>) -> Unit, failure: (Throwable) -> Unit) {
        api.getGames(input).enqueue(Loader<ListResult<Game>>(
            success = {
                val size = it.pagination.size
                val offset = it.pagination.offset
                val games = it.data.map { game -> transform(game) }
                success(ListData(size, offset, games))
            },
            failure = {
                failure(it)
            }
        ))
    }

    private fun transform(game: Game) = GameData(
        game.id,
        game.names.international,
        game.assets.coverSmall.uri,
        game.assets.coverMedium.uri,
        game.assets.coverLarge.uri
    )

}