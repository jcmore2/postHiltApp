package com.example.postapp.client

import com.example.postapp.model.canon.Comment
import com.example.postapp.model.canon.Post
import com.example.postapp.model.canon.User
import com.example.postapp.model.toComment
import com.example.postapp.model.toPost
import com.example.postapp.model.toUser
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(private val retrofitApiClient: RetrofitApiClientImpl): ApiDataSource {

    override suspend fun getAllPosts(): List<Post>? {
        return retrofitApiClient.getAllPosts()?.map { postApiDTO -> postApiDTO.toPost() }
    }

    override suspend fun getPostById(id: Int): Post? {
        return retrofitApiClient.getPostById(id)?.toPost()
    }

    override suspend fun getUserById(id: Int): User? {
        return retrofitApiClient.getUserById(id)?.toUser()
    }

    override suspend fun getCommentsByPostId(id: Int): List<Comment>? {
        return retrofitApiClient.getCommentsByPostId(id)?.map { commentApiDTO -> commentApiDTO.toComment() }
    }
}