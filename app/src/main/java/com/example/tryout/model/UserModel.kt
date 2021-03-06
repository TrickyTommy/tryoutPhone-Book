package com.example.tryout.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("password")
    val password: String

): Parcelable
