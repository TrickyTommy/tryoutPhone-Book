package com.example.tryout.views.contracts

import com.example.tryout.model.RequestSignup
import com.example.tryout.model.SignInModel
import com.example.tryout.repositories.remote.responses.SignUpResponse

interface contractSignUp {

    interface View {
    fun onSuccessSignUp(message: String) {

    }

    fun onFailedRegister(data: String) {

    }

    }

    interface Presenter {
        fun getSignUp(registerBody: RequestSignup)

    }
}