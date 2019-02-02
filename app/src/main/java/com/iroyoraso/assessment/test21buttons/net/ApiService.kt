package com.iroyoraso.assessment.test21buttons.net

import com.iroyoraso.assessment.test21buttons.data.BaseResult
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
interface ApiService {

    @GET("games")
    fun getGames(): Call<BaseResult>

}