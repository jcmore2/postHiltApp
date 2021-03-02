package com.example.postapp.model.api

data class PostApiDTO(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)