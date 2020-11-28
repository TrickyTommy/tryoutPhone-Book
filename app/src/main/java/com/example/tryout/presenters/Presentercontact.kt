package com.example.tryout.presenters

import com.example.tryout.model.SignInModel
import com.example.tryout.repositories.Remote_Repository
import com.example.tryout.views.contracts.InterfaceView

class Presentercontact
    (private val view: InterfaceView.View, private val repository: Remote_Repository) :
    InterfaceView.Presenter {
    override fun getAllContact() {
        TODO("Not yet implemented")
    }

    override fun deleteContact(contactModel: SignInModel, position: Int) {
        TODO("Not yet implemented")
    }

}