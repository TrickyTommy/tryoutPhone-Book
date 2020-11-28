package com.example.tryout.model

import com.google.gson.annotations.SerializedName

data class SignInModel(


	@field:SerializedName("email")
	val email: String,
	@field:SerializedName("password")
	val password: String
)
