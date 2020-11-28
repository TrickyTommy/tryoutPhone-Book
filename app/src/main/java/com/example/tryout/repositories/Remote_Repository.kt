package com.example.tryout.repositories


import com.example.tryout.model.RequestSignup
import com.example.tryout.repositories.remote.responses.LoginResponse
import com.example.tryout.repositories.remote.responses.ResponseCoontact
import com.example.tryout.repositories.remote.responses.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body

interface Remote_Repository {
    fun dologin(): Call<LoginResponse>
    fun getUser(): Call<ResponseCoontact>
    fun doRegister(): Call<SignUpResponse<Any?>>
}