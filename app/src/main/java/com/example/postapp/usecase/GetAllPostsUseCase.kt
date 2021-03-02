package com.example.postapp.usecase

import com.example.postapp.model.canon.Post
import com.example.postapp.repository.RepositoryImpl
import javax.inject.Inject

class GetAllPostsUseCase
    @Inject constructor(private val repositoryImpl: RepositoryImpl): UseCase<List<Post>?>{

    override suspend fun request(): List<Post>? =
        repositoryImpl.getAllPosts()
}