package com.example.postapp.model

import com.example.postapp.model.api.CommentApiDTO
import com.example.postapp.model.api.PostApiDTO
import com.example.postapp.model.api.UserApiDTO
import com.example.postapp.model.canon.Comment
import com.example.postapp.model.canon.Post
import com.example.postapp.model.canon.User
import com.example.postapp.model.local.CommentLocalDTO
import com.example.postapp.model.local.PostLocalDTO
import com.example.postapp.model.local.UserLocalDTO

fun CommentApiDTO.toComment(): Comment =
    Comment(
        postId,
        id,
        name,
        email,
        body
    )

fun PostApiDTO.toPost(): Post =
    Post(
        userId,
        id,
        title,
        body
)

fun UserApiDTO.toUser(): User =
    User(
        id,
        name,
        userName,
        email,
        phone,
        website
    )

fun CommentLocalDTO.toComment(): Comment =
    Comment(
        postId,
        id,
        name,
        email,
        body
    )

fun PostLocalDTO.toPost(): Post =
    Post(
        userId,
        id,
        title,
        body
    )

fun UserLocalDTO.toUser(): User =
    User(
        id,
        name,
        userName,
        email,
        phone,
        website
    )

fun Comment.toCommentLocalDTO(): CommentLocalDTO =
    CommentLocalDTO(
        postId,
        id,
        name,
        email,
        body
    )

fun Post.toPostLocalDTO(): PostLocalDTO =
    PostLocalDTO(
        userId,
        id,
        title,
        body
    )

fun User.toUserLocalDTO(): UserLocalDTO =
    UserLocalDTO(
        id,
        name,
        userName,
        email,
        phone,
        website
    )