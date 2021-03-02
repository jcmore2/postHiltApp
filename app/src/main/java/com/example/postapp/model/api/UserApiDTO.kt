package com.example.postapp.model.api

import com.google.gson.annotations.SerializedName

data class UserApiDTO(
    val id: Int,
    val name: String,
    @SerializedName("username")
    val userName: String,
    val email: String,
    val phone: String,
    val website: String
)