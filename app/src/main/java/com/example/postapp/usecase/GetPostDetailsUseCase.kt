package com.example.postapp.usecase

import com.example.postapp.model.canon.PostDetail
import com.example.postapp.repository.Repository
import javax.inject.Inject

class GetPostDetailsUseCase
@Inject constructor(private val repository: Repository): UseCaseWithParameter<PostDetail?, Int> {

    override suspend fun requestWithParameter(p: Int): PostDetail? {
        val post = repository.getPostById(p)
        val commentList = repository.getCommentsFromPostId(p)
        val userName = repository.getUserById(post?.userId)?.userName
        return PostDetail(
            post?.title,
            post?.body,
            userName,
            commentList
        )
    }
}