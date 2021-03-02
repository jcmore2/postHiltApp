package com.example.postapp.db

import com.example.postapp.model.canon.Comment
import com.example.postapp.model.canon.Post
import com.example.postapp.model.canon.User

interface LocalDataSource {

    suspend fun getAllPosts(): List<Post>
    suspend fun getPostById(postId: Int): Post?
    suspend fun savePost(post: Post)

    suspend fun getCommentsFromPost(postId: Int): List<Comment>
    suspend fun saveComment(comment: Comment)

    suspend fun getUserById(userId: Int): User?
    suspend fun insertUser(user: User)
}