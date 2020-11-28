package com.example.tryout.repositories.remote.services

import com.example.tryout.Constans
import com.example.tryout.model.*
import com.example.tryout.repositories.remote.responses.LoginResponse
import com.example.tryout.repositories.remote.responses.ResponseCoontact
import com.example.tryout.repositories.remote.responses.SignUpResponse

import retrofit2.Call
import retrofit2.http.*

interface UserClient {

    @POST("/api/v1/signup")
    fun doRegister(
        @Body signupRequest: RequestSignup
    ): Call<User<String>> // body data

    //TODO : Login User
    @POST("/api/v1/signin")
    fun doLogin(
        @Body signinRequest: SignInModel
    ): Call<User<UserModel>> // body data

    //TODO : Get User
    @GET("api/v1/contacts")
    fun getAllContact(
        @Header("Authorization")
        token: String
    ): Call<User<List<ResponseCoontact>>>

    @DELETE("api/v1/contacts/{id}")
    fun deleteContact(
        @Header("Authorization")
        token: String,
        @Path("id")
        id: Int
    ): Call<User<String>>

}

