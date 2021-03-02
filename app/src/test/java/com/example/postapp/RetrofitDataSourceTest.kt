package com.example.postapp

import com.example.postapp.client.RetrofitApiClientImpl
import com.example.postapp.client.RetrofitDataSource
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RetrofitDataSourceTest {

    private lateinit var retrofitApiClientImpl: RetrofitApiClientImpl
    private lateinit var retrofitDataSource: RetrofitDataSource

    private val postApiListResponse = PostMock.postApiDTOListMock
    private val postApiResponse = PostMock.posApiDTOtMock
    private val userApiResponse = UserMock.userApiDTOMock
    private val commentApiListResponse = CommentMock.commentApiDTOListMock

    private val postListResult = PostMock.postListMock
    private val postResult = PostMock.postMock
    private val userResult = UserMock.userMock
    private val commentListResult = CommentMock.commentListMock

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        retrofitApiClientImpl = Mockito.mock(RetrofitApiClientImpl::class.java)
        whenever(retrofitApiClientImpl.getAllPosts()).thenReturn(this@RetrofitDataSourceTest.postApiListResponse)
        whenever(retrofitApiClientImpl.getCommentsByPostId(1)).thenReturn(this@RetrofitDataSourceTest.commentApiListResponse)
        whenever(retrofitApiClientImpl.getPostById(1)).thenReturn(this@RetrofitDataSourceTest.postApiResponse)
        whenever(retrofitApiClientImpl.getUserById(1)).thenReturn(this@RetrofitDataSourceTest.userApiResponse)
        retrofitDataSource = RetrofitDataSource(retrofitApiClientImpl)
    }


    @Test
    fun `if RetrofitApiClientImpl return postList then RetrofitDataSource calls getAllPosts method returns same posts`() = runBlockingTest {
        val postListFromClientImpl = retrofitDataSource.getAllPosts()
        Assert.assertEquals(postListFromClientImpl, this@RetrofitDataSourceTest.postListResult)
        assertEquals(postListFromClientImpl!![0].id, this@RetrofitDataSourceTest.postListResult[0].id)
        assertEquals(postListFromClientImpl[0].userId, this@RetrofitDataSourceTest.postListResult[0].userId)
        assertEquals(postListFromClientImpl[0].title, this@RetrofitDataSourceTest.postListResult[0].title)
        assertEquals(postListFromClientImpl[0].body, this@RetrofitDataSourceTest.postListResult[0].body)
    }

    @Test
    fun `if RetrofitApiClientImpl return comments then RetrofitDataSource calls getCommentsByPostId method returns same comments`() = runBlockingTest {
        val commentListFromClientImpl = retrofitDataSource.getCommentsByPostId(1)
        Assert.assertEquals(commentListFromClientImpl, this@RetrofitDataSourceTest.commentListResult)
        assertEquals(commentListFromClientImpl!![0].id, this@RetrofitDataSourceTest.commentListResult[0].id)
        assertEquals(commentListFromClientImpl[0].postId, this@RetrofitDataSourceTest.commentListResult[0].postId)
        assertEquals(commentListFromClientImpl[0].name, this@RetrofitDataSourceTest.commentListResult[0].name)
        assertEquals(commentListFromClientImpl[0].body, this@RetrofitDataSourceTest.commentListResult[0].body)
        assertEquals(commentListFromClientImpl[0].email, this@RetrofitDataSourceTest.commentListResult[0].email)
    }

    @Test
    fun `if RetrofitApiClientImpl return post then RetrofitDataSource calls getPostById method returns same post`() = runBlockingTest {
        val postFromClientImpl = retrofitDataSource.getPostById(1)
        Assert.assertEquals(postFromClientImpl, this@RetrofitDataSourceTest.postResult)
        assertEquals(postFromClientImpl!!.id, this@RetrofitDataSourceTest.postResult.id)
        assertEquals(postFromClientImpl.userId, this@RetrofitDataSourceTest.postResult.userId)
        assertEquals(postFromClientImpl.title, this@RetrofitDataSourceTest.postResult.title)
        assertEquals(postFromClientImpl.body, this@RetrofitDataSourceTest.postResult.body)
    }

    @Test
    fun `if RetrofitApiClientImpl return user then RetrofitDataSource calls getUserById method returns same user`() = runBlockingTest {
        val userFromClientImpl = retrofitDataSource.getUserById(1)
        Assert.assertEquals(userFromClientImpl, this@RetrofitDataSourceTest.userResult)
        assertEquals(userFromClientImpl!!.id, this@RetrofitDataSourceTest.userResult.id)
        assertEquals(userFromClientImpl.name, this@RetrofitDataSourceTest.userResult.name)
        assertEquals(userFromClientImpl.userName, this@RetrofitDataSourceTest.userResult.userName)
        assertEquals(userFromClientImpl.email, this@RetrofitDataSourceTest.userResult.email)
        assertEquals(userFromClientImpl.phone, this@RetrofitDataSourceTest.userResult.phone)
        assertEquals(userFromClientImpl.website, this@RetrofitDataSourceTest.userResult.website)
    }
}