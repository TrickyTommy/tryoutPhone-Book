package com.example.tryout.model

import com.google.gson.annotations.SerializedName

class ErrorResponseModel (

    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: String,

)

