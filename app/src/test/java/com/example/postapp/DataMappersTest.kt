package com.example.postapp

import com.example.postapp.model.*
import junit.framework.TestCase
import org.junit.Test

class DataMappersTest {

    private val commentApiDTO = CommentMock.commentApiDTO
    private val postApiDTO = PostMock.posApiDTOtMock
    private val userApiDTO = UserMock.userApiDTOMock

    private val commentLocalDTO = CommentMock.commentLocalDTO
    private val postLocalDTO = PostMock.postLocalDTOMock
    private val userLocalDTO = UserMock.userLocalDTOMock

    private val commentMock = CommentMock.comment
    private val postMock = PostMock.postMock
    private val userMock = UserMock.userMock

    @Test
    fun `commentApiDTO to comment`() {
        val comment = commentApiDTO.toComment()
        TestCase.assertEquals(comment, commentMock)
    }

    @Test
    fun `postApiDTO to post`() {
        val post = postApiDTO.toPost()
        TestCase.assertEquals(post, postMock)
    }

    @Test
    fun `userApiDTO to user`() {
        val user = userApiDTO.toUser()
        TestCase.assertEquals(user, userMock)
    }

    @Test
    fun `commentLocalDTO to comment`() {
        val comment = commentLocalDTO.toComment()
        TestCase.assertEquals(comment, commentMock)
    }

    @Test
    fun `postLocalDTO to post`() {
        val post = postLocalDTO.toPost()
        TestCase.assertEquals(post, postMock)
    }

    @Test
    fun `userLocalDTO to user`() {
        val user = userLocalDTO.toUser()
        TestCase.assertEquals(user, userMock)
    }

    @Test
    fun `comment to commentLocalDTO`() {
        val comment = commentMock.toCommentLocalDTO()
        TestCase.assertEquals(comment, commentLocalDTO)
    }

    @Test
    fun `post to postLocalDTO`() {
        val post = postMock.toPostLocalDTO()
        TestCase.assertEquals(post, postLocalDTO)
    }

    @Test
    fun `user to userLocalDTO`() {
        val user = userMock.toUserLocalDTO()
        TestCase.assertEquals(user, userLocalDTO)
    }
}