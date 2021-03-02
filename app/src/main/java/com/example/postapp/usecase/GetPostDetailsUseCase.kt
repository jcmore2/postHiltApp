package com.example.postapp.usecase

import com.example.postapp.model.canon.PostDetail
import com.example.postapp.repository.RepositoryImpl
import javax.inject.Inject

class GetPostDetailsUseCase
@Inject constructor(private val repositoryImpl: RepositoryImpl): UseCaseWithParameter<PostDetail?, Int> {

    override suspend fun requestWithParameter(p: Int): PostDetail? {
        val post = repositoryImpl.getPostById(p)
        val commentList = repositoryImpl.getCommentsFromPostId(p)
        val userName = repositoryImpl.getUserById(post?.userId)?.userName
        return PostDetail(
            post?.title,
            post?.body,
            userName,
            commentList
        )
    }
}