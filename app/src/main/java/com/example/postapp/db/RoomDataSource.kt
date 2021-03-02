package com.example.postapp.db

import android.content.Context
import com.example.postapp.model.*
import com.example.postapp.model.canon.Comment
import com.example.postapp.model.canon.Post
import com.example.postapp.model.canon.User
import javax.inject.Inject

class RoomDataSource @Inject constructor(context: Context): LocalDataSource {
    private val db = PostDataBase.getInstance(context)

    override suspend fun getAllPosts(): List<Post> {
        return db.postDAO.getAll().map { postLocalDTO ->  postLocalDTO.toPost() }
    }

    override suspend fun getPostById(postId: Int): Post? {
        return db.postDAO.getPostById(postId).toPost()
    }

    override suspend fun savePost(post: Post) {
        db.postDAO.insertPost(post.toPostLocalDTO())
    }

    override suspend fun getCommentsFromPost(postId: Int): List<Comment> {
        return db.commentDAO.getCommentsFromPost(postId).map { commentLocalDTO -> commentLocalDTO.toComment() }
    }

    override suspend fun saveComment(comment: Comment) {
        db.commentDAO.insertComment(comment.toCommentLocalDTO())
    }

    override suspend fun getUserById(userId: Int): User? {
        return db.userDAO.getUserById(userId)?.toUser()
    }

    override suspend fun insertUser(user: User) {
        db.userDAO.insertUser(user.toUserLocalDTO())
    }


}