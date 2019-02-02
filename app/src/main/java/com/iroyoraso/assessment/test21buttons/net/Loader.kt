package com.iroyoraso.assessment.test21buttons.net

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class Loader<T>(private val success: (T) -> Unit, private val failure: (Throwable) -> Unit) : Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        failure(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                success(body)
            }
        } else {

        }

    }

}