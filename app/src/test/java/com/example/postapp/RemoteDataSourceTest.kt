package com.example.postapp

import com.example.postapp.client.RetrofitApiClientImpl
import com.example.postapp.client.RemoteDataSource
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RemoteDataSourceTest {

    private lateinit var retrofitApiClientImpl: RetrofitApiClientImpl
    private lateinit var remoteDataSource: RemoteDataSource

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
        whenever(retrofitApiClientImpl.getAllPosts()).thenReturn(this@RemoteDataSourceTest.postApiListResponse)
        whenever(retrofitApiClientImpl.getCommentsByPostId(1)).thenReturn(this@RemoteDataSourceTest.commentApiListResponse)
        whenever(retrofitApiClientImpl.getPostById(1)).thenReturn(this@RemoteDataSourceTest.postApiResponse)
        whenever(retrofitApiClientImpl.getUserById(1)).thenReturn(this@RemoteDataSourceTest.userApiResponse)
        remoteDataSource = RemoteDataSource(retrofitApiClientImpl)
    }


    @Test
    fun `if RetrofitApiClientImpl return postList then RetrofitDataSource calls getAllPosts method returns same posts`() = runBlockingTest {
        val postListFromClientImpl = remoteDataSource.getAllPosts()
        Assert.assertEquals(postListFromClientImpl, this@RemoteDataSourceTest.postListResult)
        assertEquals(postListFromClientImpl!![0].id, this@RemoteDataSourceTest.postListResult[0].id)
        assertEquals(postListFromClientImpl[0].userId, this@RemoteDataSourceTest.postListResult[0].userId)
        assertEquals(postListFromClientImpl[0].title, this@RemoteDataSourceTest.postListResult[0].title)
        assertEquals(postListFromClientImpl[0].body, this@RemoteDataSourceTest.postListResult[0].body)
    }

    @Test
    fun `if RetrofitApiClientImpl return comments then RetrofitDataSource calls getCommentsByPostId method returns same comments`() = runBlockingTest {
        val commentListFromClientImpl = remoteDataSource.getCommentsByPostId(1)
        Assert.assertEquals(commentListFromClientImpl, this@RemoteDataSourceTest.commentListResult)
        assertEquals(commentListFromClientImpl!![0].id, this@RemoteDataSourceTest.commentListResult[0].id)
        assertEquals(commentListFromClientImpl[0].postId, this@RemoteDataSourceTest.commentListResult[0].postId)
        assertEquals(commentListFromClientImpl[0].name, this@RemoteDataSourceTest.commentListResult[0].name)
        assertEquals(commentListFromClientImpl[0].body, this@RemoteDataSourceTest.commentListResult[0].body)
        assertEquals(commentListFromClientImpl[0].email, this@RemoteDataSourceTest.commentListResult[0].email)
    }

    @Test
    fun `if RetrofitApiClientImpl return post then RetrofitDataSource calls getPostById method returns same post`() = runBlockingTest {
        val postFromClientImpl = remoteDataSource.getPostById(1)
        Assert.assertEquals(postFromClientImpl, this@RemoteDataSourceTest.postResult)
        assertEquals(postFromClientImpl!!.id, this@RemoteDataSourceTest.postResult.id)
        assertEquals(postFromClientImpl.userId, this@RemoteDataSourceTest.postResult.userId)
        assertEquals(postFromClientImpl.title, this@RemoteDataSourceTest.postResult.title)
        assertEquals(postFromClientImpl.body, this@RemoteDataSourceTest.postResult.body)
    }

    @Test
    fun `if RetrofitApiClientImpl return user then RetrofitDataSource calls getUserById method returns same user`() = runBlockingTest {
        val userFromClientImpl = remoteDataSource.getUserById(1)
        Assert.assertEquals(userFromClientImpl, this@RemoteDataSourceTest.userResult)
        assertEquals(userFromClientImpl!!.id, this@RemoteDataSourceTest.userResult.id)
        assertEquals(userFromClientImpl.name, this@RemoteDataSourceTest.userResult.name)
        assertEquals(userFromClientImpl.userName, this@RemoteDataSourceTest.userResult.userName)
        assertEquals(userFromClientImpl.email, this@RemoteDataSourceTest.userResult.email)
        assertEquals(userFromClientImpl.phone, this@RemoteDataSourceTest.userResult.phone)
        assertEquals(userFromClientImpl.website, this@RemoteDataSourceTest.userResult.website)
    }
}