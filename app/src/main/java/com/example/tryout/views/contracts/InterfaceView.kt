package com.example.tryout.views.contracts

import com.example.tryout.model.SignInModel
import com.example.tryout.repositories.remote.responses.ResponseCoontact

interface InterfaceView {
    interface View {
        fun onSuccessGetAllContact(list: List<ResponseCoontact>)
        fun onError(t: Throwable)
        fun onLoading(isLoading: Boolean)
        fun onSuccesDeleteContact(message:String,id:Int)
    }

    interface Presenter {
        fun getAllContact()
        fun deleteContact(contactModel: SignInModel, position: Int)

    }
}