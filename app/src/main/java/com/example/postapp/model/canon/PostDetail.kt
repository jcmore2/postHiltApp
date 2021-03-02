package com.example.postapp.model.canon

data class PostDetail(
    val title: String?,
    val body: String?,
    val user: String?,
    val commentList: List<Comment>?
)