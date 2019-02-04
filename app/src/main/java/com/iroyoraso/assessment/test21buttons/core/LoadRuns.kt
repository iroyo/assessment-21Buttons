package com.iroyoraso.assessment.test21buttons.core

import com.iroyoraso.assessment.test21buttons.core.entities.ListData
import com.iroyoraso.assessment.test21buttons.core.entities.RunData
import com.iroyoraso.assessment.test21buttons.core.entities.TimeStats
import com.iroyoraso.assessment.test21buttons.data.ListResult
import com.iroyoraso.assessment.test21buttons.data.Run
import com.iroyoraso.assessment.test21buttons.net.ApiService
import com.iroyoraso.assessment.test21buttons.net.Loader

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
class LoadRuns(private val api: ApiService) : Action<String, ListData<RunData>> {

    override fun performWith(input: String, success: (ListData<RunData>) -> Unit, failure: (Throwable) -> Unit) {
        api.getRuns(input).enqueue(Loader<ListResult<Run>>(
            success = {
                val size = it.pagination.size
                val offset = it.pagination.offset
                val runs = it.data.map { run -> transform(run) }
                success(ListData(size, offset, runs))
            },
            failure = {
                failure(it)
            }
        ))
    }

    private fun transform(run: Run): RunData {
        val idPlayer = if (run.players.isNotEmpty()) {
            run.players[0].id
        } else {
            null
        }

        val uriVideo = if (run.videos != null) {
            if (run.videos.links.isNotEmpty()) {
                run.videos.links[0].uri
            } else {
                null
            }
        } else {
            null
        }

        val realTime = transform(run.times.realtimeInMinutes)
        val ingameTime = transform(run.times.ingameInMinutes)
        val primaryTime = transform(run.times.primaryInMinutes)
        return RunData(run.id, idPlayer, uriVideo, realTime, ingameTime, primaryTime)
    }

    private fun transform(time: Int) : TimeStats? {
        return if (time == 0) {
            null
        } else {
            val hours = time / 3600
            val minutes = (time % 3600) / 60
            val seconds = time % 60
            TimeStats(hours, minutes, seconds)
        }
    }
}