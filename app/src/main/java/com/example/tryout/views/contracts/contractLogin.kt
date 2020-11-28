package com.example.tryout.views.contracts

import com.example.tryout.model.SignInModel
import com.example.tryout.repositories.remote.responses.ResponseCoontact

interface contractLogin {
    interface View {
        fun onSuccesslogin(message : String)
        fun onError(t: Throwable)
        fun onFailedLogin(message: String)

        fun onLoading(isLoading: Boolean)
    }

    interface Presenter {
        fun getlogin( loginBody:SignInModel)

    }
}