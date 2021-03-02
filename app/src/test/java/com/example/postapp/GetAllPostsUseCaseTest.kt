package com.example.postapp

import com.example.postapp.repository.RepositoryImpl
import com.example.postapp.usecase.GetAllPostsUseCase
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAllPostsUseCaseTest {

    lateinit var repository: RepositoryImpl
    lateinit var getAllPostsUseCase: GetAllPostsUseCase

    private val postList = PostMock.postListMock

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        repository = Mockito.mock(RepositoryImpl::class.java)
        whenever(repository.getAllPosts()).thenReturn(this@GetAllPostsUseCaseTest.postList)
        getAllPostsUseCase = GetAllPostsUseCase(repository)
    }

    @Test
    fun `if ApiRepository return posts then GetAllPostsUseCase returns same Post list`() = runBlockingTest {
        val postListFromUseCase = getAllPostsUseCase.request()
        Assert.assertEquals(postListFromUseCase, this@GetAllPostsUseCaseTest.postList)
        Assert.assertEquals(postListFromUseCase!![0].body, this@GetAllPostsUseCaseTest.postList[0].body)
        Assert.assertEquals(postListFromUseCase[0].title, this@GetAllPostsUseCaseTest.postList[0].title)
        Assert.assertEquals(postListFromUseCase[0].userId, this@GetAllPostsUseCaseTest.postList[0].userId)
        Assert.assertEquals(postListFromUseCase[0].id, this@GetAllPostsUseCaseTest.postList[0].id)

    }
}