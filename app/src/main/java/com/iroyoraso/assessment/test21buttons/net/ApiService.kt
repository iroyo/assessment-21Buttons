package com.iroyoraso.assessment.test21buttons.net

import com.iroyoraso.assessment.test21buttons.data.GameListResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
interface ApiService {

    @GET("games")
    fun getGames(@Query("offset") offset: Int): Call<GameListResult>

}