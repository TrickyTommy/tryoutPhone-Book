package com.example.tryout.repositories.remote

import com.example.tryout.model.User
import com.example.tryout.repositories.remote.responses.ResponseCoontact
import com.example.tryout.repositories.remote.services.UserClient
import retrofit2.Call

class contactRemoteRepository (private val service: UserClient) {


    fun getAllContact(token: String): Call<User<List<ResponseCoontact>>> {
        return service.getAllContact(token)
    }

    fun deleteContact(token: String, id: Int): Call<User<String>> {
        return service.deleteContact(token, id)
    }
}
