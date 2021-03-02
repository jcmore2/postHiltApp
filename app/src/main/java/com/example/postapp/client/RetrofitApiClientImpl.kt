package com.example.postapp.client

import com.example.postapp.model.api.CommentApiDTO
import com.example.postapp.model.api.PostApiDTO
import com.example.postapp.model.api.UserApiDTO
import javax.inject.Inject

class RetrofitApiClientImpl
    @Inject constructor(private val retrofitApiClient: RetrofitApiClient):
    RetrofitApiClient {

    override suspend fun getAllPosts(): List<PostApiDTO>? {
        return retrofitApiClient.getAllPosts()
    }

    override suspend fun getPostById(id: Int): PostApiDTO? {
        return retrofitApiClient.getPostById(id)
    }

    override suspend fun getUserById(id: Int): UserApiDTO? {
        return retrofitApiClient.getUserById(id)
    }

    override suspend fun getCommentsByPostId(id: Int): List<CommentApiDTO>? {
        return retrofitApiClient.getCommentsByPostId(id)
    }


}