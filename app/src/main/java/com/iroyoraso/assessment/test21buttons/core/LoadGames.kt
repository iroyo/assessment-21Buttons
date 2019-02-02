package com.iroyoraso.assessment.test21buttons.core

import com.iroyoraso.assessment.test21buttons.data.BaseResult
import com.iroyoraso.assessment.test21buttons.data.Game
import com.iroyoraso.assessment.test21buttons.net.ApiService
import com.iroyoraso.assessment.test21buttons.net.Loader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class LoadGames(private val api: ApiService) : Action<Int, List<Game>> {

    override fun performWith(input: Int, callback: (List<Game>) -> Unit) {
        api.getGames().enqueue(Loader<BaseResult>(
            success = {

            },
            failure = {

            }
        ))
    }


}