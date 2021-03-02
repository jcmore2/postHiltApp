package com.example.postapp.repository

import com.example.postapp.model.canon.Comment
import com.example.postapp.model.canon.Post
import com.example.postapp.model.canon.User

interface Repository {

    suspend fun getAllPosts(): List<Post>?

    suspend fun getPostById(id: Int): Post?

    suspend fun getCommentsFromPostId(id: Int): List<Comment>?

    suspend fun getUserById(id: Int?): User?
}