package com.example.tryout.repositories.remote.responses

import com.google.gson.annotations.SerializedName

data class SignUpResponse<T>(

	@field:SerializedName("data")
	val data: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean
)
