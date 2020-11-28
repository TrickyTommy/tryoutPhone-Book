package com.example.tryout.fragment


import com.example.tryout.repositories.localStorages.*

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tryout.R
import com.example.tryout.databinding.FragmentLoginBinding
import com.example.tryout.extensions.isEmail
import com.example.tryout.extensions.isPassword
import com.example.tryout.model.SignInModel
import com.example.tryout.presenters.PresenterLogin
import com.example.tryout.repositories.remote.RemoteRepository
import com.example.tryout.repositories.remote.clients.ApiClient
import com.example.tryout.repositories.remote.services.UserClient
import com.example.tryout.views.contracts.contractLogin


class LoginFragment : Fragment(),contractLogin.View {

    private lateinit var binding: FragmentLoginBinding

    private val service: UserClient by lazy{ApiClient.userService}
    private val repositoryUser: RemoteRepository by lazy { RemoteRepository(service) }
    private val presenter: PresenterLogin by lazy { PresenterLogin(this, repositoryUser) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        setView()
        return binding.root
    }

    private fun setView(){
        binding.apply {
            btnLoginFr.setOnClickListener {
                presenter.getlogin(SignInModel(tieEmail.text.toString(), tiePassword.text.toString()))
            }
            btnRegisterFr.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment2_to_signUpFragment)
            }
        }
    }

    override fun onSuccesslogin(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_loginFragment2_to_contactFragment)
    }

    override fun onError(t: Throwable) {
        TODO("Not yet implemented")
    }

    override fun onFailedLogin(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onLoading(isLoading: Boolean) {
        TODO("Not yet implemented")
    }



}