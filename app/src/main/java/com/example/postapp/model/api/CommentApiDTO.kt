package com.example.postapp.model.api

data class CommentApiDTO(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)