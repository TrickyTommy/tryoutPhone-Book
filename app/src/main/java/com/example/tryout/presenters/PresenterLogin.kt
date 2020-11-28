package com.example.tryout.presenters

import com.example.tryout.Apk
import com.example.tryout.model.*
import com.example.tryout.repositories.Remote_Repository
import com.example.tryout.repositories.localStorages.LocalStorage
import com.example.tryout.repositories.remote.RemoteRepository
import com.example.tryout.repositories.remote.responses.LoginResponse
import com.example.tryout.repositories.remote.responses.ResponseCoontact
import com.example.tryout.views.contracts.InterfaceView
import com.example.tryout.views.contracts.contractLogin
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterLogin(
    private val view: contractLogin.View,
    private val repository: RemoteRepository
) :
    contractLogin.Presenter {

    private val prefs: LocalStorage by lazy {
        LocalStorage(Apk.instance)
    }

    override fun getlogin(loginBody: SignInModel) {
        repository.userLogin(loginBody).enqueue(object : Callback<User<UserModel>> {

            override fun onResponse(
                call: Call<User<UserModel>>,
                response: Response<User<UserModel>>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.status) {
                        val user = response.body()!!.data

                        prefs.email = user.email
                        prefs.name = user.name
                        prefs.password = user.password
                        prefs.token = "Bearer ${user.token}"

                        prefs.loggedIn = true

                        view.onSuccesslogin(response.body()!!.message)
                    }

                } else {
                    if (response.errorBody() != null) {
                        val gson = Gson()
                        val message: ErrorResponseModel = gson.fromJson(
                            response.errorBody()!!.charStream(),
                            ErrorResponseModel::class.java
                        )

                        view.onFailedLogin(message.data)
                    }
                }
            }

            override fun onFailure(call: Call<User<UserModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}
