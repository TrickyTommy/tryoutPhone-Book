package com.example.tryout.model

import com.google.gson.annotations.SerializedName

data class User <T> (
    @SerializedName("data")
    val data: T,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: String,
)