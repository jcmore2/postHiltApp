package com.example.postapp.client

import com.example.postapp.model.api.CommentApiDTO
import com.example.postapp.model.api.PostApiDTO
import com.example.postapp.model.api.UserApiDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApiClient {

    @GET("posts")
    suspend fun getAllPosts()
            : List<PostApiDTO>?

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): PostApiDTO?

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserApiDTO?

    @GET("comments")
    suspend fun getCommentsByPostId(@Query("postId")id: Int): List<CommentApiDTO>?
}