package com.example.postapp

import com.example.postapp.client.RetrofitDataSource
import com.example.postapp.db.RoomDataSource
import com.example.postapp.repository.RepositoryImpl
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    private lateinit var retrofitDataSource: RetrofitDataSource
    private lateinit var roomDataSource: RoomDataSource
    private lateinit var repositoryImpl: RepositoryImpl

    private val postListResult = PostMock.postListMock
    private val postResult = PostMock.postMock
    private val userResult = UserMock.userMock
    private val commentListResult = CommentMock.commentListMock

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        retrofitDataSource = Mockito.mock(RetrofitDataSource::class.java)
        roomDataSource = Mockito.mock(RoomDataSource::class.java)
        whenever(roomDataSource.getAllPosts()).thenReturn(this@RepositoryImplTest.postListResult)
        whenever(roomDataSource.getCommentsFromPost(1)).thenReturn(this@RepositoryImplTest.commentListResult)
        whenever(roomDataSource.getPostById(1)).thenReturn(this@RepositoryImplTest.postResult)
        whenever(roomDataSource.getUserById(1)).thenReturn(this@RepositoryImplTest.userResult)
        whenever(retrofitDataSource.getAllPosts()).thenReturn(this@RepositoryImplTest.postListResult)
        whenever(retrofitDataSource.getCommentsByPostId(1)).thenReturn(this@RepositoryImplTest.commentListResult)
        whenever(retrofitDataSource.getPostById(1)).thenReturn(this@RepositoryImplTest.postResult)
        whenever(retrofitDataSource.getUserById(1)).thenReturn(this@RepositoryImplTest.userResult)
        repositoryImpl = RepositoryImpl(retrofitDataSource, roomDataSource)
    }


    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getAllPosts method`() = runBlockingTest {
        whenever(roomDataSource.getAllPosts()).thenReturn(null)
        repositoryImpl.getAllPosts()
        verify(roomDataSource, times(1)).getAllPosts()
        verify(retrofitDataSource, times(1)).getAllPosts()
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getAllPosts method and return same posts`() = runBlockingTest {
        whenever(roomDataSource.getAllPosts()).thenReturn(null)
        val postListFromRetrofit = repositoryImpl.getAllPosts()
        Assert.assertEquals(postListFromRetrofit, this@RepositoryImplTest.postListResult)
        Assert.assertEquals(postListFromRetrofit!![0].id, this@RepositoryImplTest.postListResult[0].id)
        Assert.assertEquals(postListFromRetrofit[0].userId, this@RepositoryImplTest.postListResult[0].userId)
        Assert.assertEquals(postListFromRetrofit[0].title, this@RepositoryImplTest.postListResult[0].title)
        Assert.assertEquals(postListFromRetrofit[0].body, this@RepositoryImplTest.postListResult[0].body)
    }

    @Test
    fun `if RoomDataSource return postList then RepositoryImpl calls getAllPosts method returns same posts`() = runBlockingTest {
        val postListFromDB = repositoryImpl.getAllPosts()
        Assert.assertEquals(postListFromDB, this@RepositoryImplTest.postListResult)
        Assert.assertEquals(postListFromDB!![0].id, this@RepositoryImplTest.postListResult[0].id)
        Assert.assertEquals(postListFromDB[0].userId, this@RepositoryImplTest.postListResult[0].userId)
        Assert.assertEquals(postListFromDB[0].title, this@RepositoryImplTest.postListResult[0].title)
        Assert.assertEquals(postListFromDB[0].body, this@RepositoryImplTest.postListResult[0].body)
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getCommentsByPostId method`() = runBlockingTest {
        whenever(roomDataSource.getCommentsFromPost(1)).thenReturn(null)
        repositoryImpl.getCommentsFromPostId(1)
        verify(roomDataSource, times(1)).getCommentsFromPost(1)
        verify(retrofitDataSource, times(1)).getCommentsByPostId(1)
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getCommentsByPostId method and return same comments`() = runBlockingTest {
        whenever(roomDataSource.getCommentsFromPost(1)).thenReturn(null)
        val commentsListFromRetrofit = repositoryImpl.getCommentsFromPostId(1)
        Assert.assertEquals(commentsListFromRetrofit, this@RepositoryImplTest.commentListResult)
        Assert.assertEquals(commentsListFromRetrofit!![0].id, this@RepositoryImplTest.commentListResult[0].id)
        Assert.assertEquals(commentsListFromRetrofit[0].postId, this@RepositoryImplTest.commentListResult[0].postId)
        Assert.assertEquals(commentsListFromRetrofit[0].name, this@RepositoryImplTest.commentListResult[0].name)
        Assert.assertEquals(commentsListFromRetrofit[0].body, this@RepositoryImplTest.commentListResult[0].body)
        Assert.assertEquals(commentsListFromRetrofit[0].email, this@RepositoryImplTest.commentListResult[0].email)
    }

    @Test
    fun `if RoomDataSource return comments then RepositoryImpl calls getCommentsByPostId method returns same comments`() = runBlockingTest {
        val commentListFromDB = repositoryImpl.getCommentsFromPostId(1)
        Assert.assertEquals(commentListFromDB, this@RepositoryImplTest.commentListResult)
        Assert.assertEquals(commentListFromDB!![0].id, this@RepositoryImplTest.commentListResult[0].id)
        Assert.assertEquals(commentListFromDB[0].postId, this@RepositoryImplTest.commentListResult[0].postId)
        Assert.assertEquals(commentListFromDB[0].name, this@RepositoryImplTest.commentListResult[0].name)
        Assert.assertEquals(commentListFromDB[0].body, this@RepositoryImplTest.commentListResult[0].body)
        Assert.assertEquals(commentListFromDB[0].email, this@RepositoryImplTest.commentListResult[0].email)
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getPostById method`() = runBlockingTest {
        whenever(roomDataSource.getPostById(1)).thenReturn(null)
        repositoryImpl.getPostById(1)
        verify(roomDataSource, times(1)).getPostById(1)
        verify(retrofitDataSource, times(1)).getPostById(1)
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getPostById method and return same post`() = runBlockingTest {
        whenever(roomDataSource.getPostById(1)).thenReturn(null)
        val postFromRetrofit = repositoryImpl.getPostById(1)
        Assert.assertEquals(postFromRetrofit, this@RepositoryImplTest.postResult)
        Assert.assertEquals(postFromRetrofit!!.id, this@RepositoryImplTest.postResult.id)
        Assert.assertEquals(postFromRetrofit.userId, this@RepositoryImplTest.postResult.userId)
        Assert.assertEquals(postFromRetrofit.title, this@RepositoryImplTest.postResult.title)
        Assert.assertEquals(postFromRetrofit.body, this@RepositoryImplTest.postResult.body)
    }

    @Test
    fun `if RoomDataSource return post then RepositoryImpl calls getPostById method returns same post`() = runBlockingTest {
        val postFromDB = repositoryImpl.getPostById(1)
        Assert.assertEquals(postFromDB, this@RepositoryImplTest.postResult)
        Assert.assertEquals(postFromDB!!.id, this@RepositoryImplTest.postResult.id)
        Assert.assertEquals(postFromDB.userId, this@RepositoryImplTest.postResult.userId)
        Assert.assertEquals(postFromDB.title, this@RepositoryImplTest.postResult.title)
        Assert.assertEquals(postFromDB.body, this@RepositoryImplTest.postResult.body)
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getUserById method`() = runBlockingTest {
        whenever(roomDataSource.getUserById(1)).thenReturn(null)
        repositoryImpl.getUserById(1)
        verify(roomDataSource, times(1)).getUserById(1)
        verify(retrofitDataSource, times(1)).getUserById(1)
    }

    @Test
    fun `if RoomDataSource return null then RepositoryImpl calls RetrofitDataSource getUserById method and return same user`() = runBlockingTest {
        whenever(roomDataSource.getUserById(1)).thenReturn(null)
        val userFromRetrofit = repositoryImpl.getUserById(1)
        Assert.assertEquals(userFromRetrofit, this@RepositoryImplTest.userResult)
        Assert.assertEquals(userFromRetrofit!!.id, this@RepositoryImplTest.userResult.id)
        Assert.assertEquals(userFromRetrofit.name, this@RepositoryImplTest.userResult.name)
        Assert.assertEquals(userFromRetrofit.userName, this@RepositoryImplTest.userResult.userName)
        Assert.assertEquals(userFromRetrofit.email, this@RepositoryImplTest.userResult.email)
        Assert.assertEquals(userFromRetrofit.phone, this@RepositoryImplTest.userResult.phone)
        Assert.assertEquals(userFromRetrofit.website, this@RepositoryImplTest.userResult.website)
    }

    @Test
    fun `if RoomDataSource return user then RepositoryImpl calls getUserById method returns same user`() = runBlockingTest {
        val userFromDB = repositoryImpl.getUserById(1)
        Assert.assertEquals(userFromDB, this@RepositoryImplTest.userResult)
        Assert.assertEquals(userFromDB!!.id, this@RepositoryImplTest.userResult.id)
        Assert.assertEquals(userFromDB.name, this@RepositoryImplTest.userResult.name)
        Assert.assertEquals(userFromDB.userName, this@RepositoryImplTest.userResult.userName)
        Assert.assertEquals(userFromDB.email, this@RepositoryImplTest.userResult.email)
        Assert.assertEquals(userFromDB.phone, this@RepositoryImplTest.userResult.phone)
        Assert.assertEquals(userFromDB.website, this@RepositoryImplTest.userResult.website)
    }
}