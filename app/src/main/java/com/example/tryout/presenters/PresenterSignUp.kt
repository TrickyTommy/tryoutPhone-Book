package com.example.tryout.presenters

import com.example.tryout.Apk
import com.example.tryout.model.ErrorResponseModel
import com.example.tryout.model.RequestSignup
import com.example.tryout.model.User
import com.example.tryout.repositories.localStorages.LocalStorage
import com.example.tryout.repositories.remote.RemoteRepository
import com.example.tryout.views.contracts.contractSignUp
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterSignUp(
    private val view: contractSignUp.View,
    private val repository: RemoteRepository
) :
    contractSignUp.Presenter {
    private val prefs: LocalStorage by lazy {
        LocalStorage(Apk.instance)
    }

    override fun getSignUp(registerBody: RequestSignup) {
        repository.userregister(registerBody).enqueue(object : Callback<User<String>> {
            override fun onResponse(call: Call<User<String>>, response: Response<User<String>>) {
                if (response.isSuccessful) {
                    if (response.body()!!.status) {
//                        val user = response.body()!!.data

                        prefs.email = registerBody.email
                        prefs.name = registerBody.name
                        prefs.password = registerBody.password
                        prefs.token = "Bearer ${response.body()!!.data}"
                        prefs.loggedIn = true


                        view.onSuccessSignUp(response.body()!!.message)
                    }

                } else {
                    if (response.errorBody() != null) {
                        val gson = Gson()
                        val message: ErrorResponseModel = gson.fromJson(
                            response.errorBody()!!.charStream(),
                            ErrorResponseModel::class.java
                        )

                        view.onFailedRegister(message.data)
                    }
                }
            }

            override fun onFailure(call: Call<User<String>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}