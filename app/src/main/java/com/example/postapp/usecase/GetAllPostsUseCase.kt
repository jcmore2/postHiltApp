package com.example.postapp.usecase

import com.example.postapp.model.canon.Post
import com.example.postapp.repository.Repository
import javax.inject.Inject

class GetAllPostsUseCase
@Inject constructor(private val repository: Repository) : UseCase<List<Post>?> {

    override suspend fun request(): List<Post>? =
        repository.getAllPosts()
}