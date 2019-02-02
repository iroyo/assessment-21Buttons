package com.iroyoraso.assessment.test21buttons.core

import com.iroyoraso.assessment.test21buttons.data.BaseResult
import com.iroyoraso.assessment.test21buttons.data.Game
import com.iroyoraso.assessment.test21buttons.net.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class LoadGames(val api: ApiService) : Action<Int, List<Game>> {

    override fun performWith(input: Int, callback: (List<Game>) -> Unit) {
        api.getGames().enqueue(object : Callback<BaseResult> {

            override fun onFailure(call: Call<BaseResult>, t: Throwable) {

            }

            override fun onResponse(call: Call<BaseResult>, response: Response<BaseResult>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        callback(result.data)
                    }
                }
            }

        })
    }


}