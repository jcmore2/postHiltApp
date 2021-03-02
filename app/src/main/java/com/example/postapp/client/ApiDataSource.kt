package com.example.postapp.client

import com.example.postapp.model.canon.Comment
import com.example.postapp.model.canon.Post
import com.example.postapp.model.canon.User

interface ApiDataSource {

    suspend fun getAllPosts(): List<Post>?
    suspend fun getPostById(id: Int): Post?
    suspend fun getUserById(id: Int): User?
    suspend fun getCommentsByPostId(id: Int): List<Comment>?

}