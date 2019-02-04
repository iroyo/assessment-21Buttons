package com.iroyoraso.assessment.test21buttons.core

import com.iroyoraso.assessment.test21buttons.core.entities.UserData
import com.iroyoraso.assessment.test21buttons.data.User
import com.iroyoraso.assessment.test21buttons.data.UserResult
import com.iroyoraso.assessment.test21buttons.net.ApiService
import com.iroyoraso.assessment.test21buttons.net.Loader

/**
 * Created by iroyo on 3/2/19.
 * Mail: iroyoraso@gmail.com
 */
class LoadUser(private val api: ApiService) : Action<String, UserData> {

    override fun performWith(input: String, success: (UserData) -> Unit, failure: (Throwable) -> Unit) {
       api.getUser(input).enqueue(Loader<UserResult>(
           success = { success(transform(it.data)) },
           failure = { failure(it) }
       ))
    }

    private fun transform(user: User): UserData {
        return UserData(
            user.id,
            user.names.international,
            user.location?.region?.names?.international,
            user.location?.country?.names?.international
        )
    }

}