package com.example.postapp

import com.example.postapp.repository.RepositoryImpl
import com.example.postapp.usecase.GetPostDetailsUseCase
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetPostDetailsUseCaseTest {

    lateinit var repository: RepositoryImpl
    lateinit var detailUseCase: GetPostDetailsUseCase

    private val postDetail = PostDetailMock.postDetailMock
    private val post = PostMock.postMock
    private val commentList = CommentMock.commentListMock
    private val user = UserMock.userMock

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        repository = Mockito.mock(RepositoryImpl::class.java)
        whenever(repository.getPostById(1)).thenReturn(this@GetPostDetailsUseCaseTest.post)
        whenever(repository.getCommentsFromPostId(1)).thenReturn(this@GetPostDetailsUseCaseTest.commentList)
        whenever(repository.getUserById(1)).thenReturn(this@GetPostDetailsUseCaseTest.user)
        detailUseCase = GetPostDetailsUseCase(repository)
    }

    @Test
    fun `if ApiRepository return postDetails then GetPostDetailsUseCase returns same PostDetails`() = runBlockingTest {
        val detailResponseFromUseCase = detailUseCase.requestWithParameter(1)
        Assert.assertEquals(detailResponseFromUseCase, this@GetPostDetailsUseCaseTest.postDetail)
        Assert.assertEquals(detailResponseFromUseCase!!.title, this@GetPostDetailsUseCaseTest.postDetail.title)
        Assert.assertEquals(detailResponseFromUseCase.body, this@GetPostDetailsUseCaseTest.postDetail.body)
        Assert.assertEquals(detailResponseFromUseCase.user, this@GetPostDetailsUseCaseTest.postDetail.user)
        Assert.assertEquals(detailResponseFromUseCase.commentList, this@GetPostDetailsUseCaseTest.postDetail.commentList)
    }
}