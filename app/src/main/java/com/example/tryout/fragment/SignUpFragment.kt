package com.example.tryout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tryout.R
import com.example.tryout.databinding.FragmentSignUpBinding
import com.example.tryout.extensions.isEmail
import com.example.tryout.extensions.isName
import com.example.tryout.extensions.isPassword
import com.example.tryout.model.RequestSignup
import com.example.tryout.presenters.PresenterSignUp
import com.example.tryout.repositories.localStorages.LocalStorage
import com.example.tryout.repositories.remote.RemoteRepository
import com.example.tryout.repositories.remote.clients.ApiClient
import com.example.tryout.repositories.remote.services.UserClient
import com.example.tryout.views.contracts.contractSignUp


class SignUpFragment : Fragment(), contractSignUp.View {


    private lateinit var binding: FragmentSignUpBinding
    private val service: UserClient by lazy{ ApiClient.userService }
    private val repositoryUser: RemoteRepository by lazy {RemoteRepository(service)}
    private val presenter: PresenterSignUp by lazy {PresenterSignUp(this, repositoryUser)}



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        setView()

        return binding.root
    }

    private fun setView(){
        binding.apply{
            btnRegisterFr.setOnClickListener {
                presenter.getSignUp(
                    RequestSignup(
                    tieName.text.toString(),
                    tieUsername.text.toString(),
                    tiePassword.text.toString(),
                )
                )
            }
            btnLoginFr.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)

            }
        }
    }

    override fun onSuccessSignUp(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_signUpFragment_to_contactFragment)
    }

    override fun onFailedRegister(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


}