package com.example.tryout.repositories.remote

import com.example.tryout.model.RequestSignup
import com.example.tryout.model.SignInModel
import com.example.tryout.model.User
import com.example.tryout.model.UserModel
import com.example.tryout.repositories.remote.responses.ResponseCoontact
import com.example.tryout.repositories.remote.responses.SignUpResponse
import com.example.tryout.repositories.remote.services.UserClient
import retrofit2.Call

class RemoteRepository(private val service: UserClient)  {
    fun userLogin(loginBody:SignInModel): Call<User<UserModel>> {
        return service.doLogin(loginBody)
    }
    fun userregister(bodyRegistration: RequestSignup):Call<User<String>> {
        return service.doRegister(bodyRegistration)
    }

}