package com.example.postapp

import com.example.postapp.model.canon.PostDetail

object PostDetailMock {

    val postDetailMock = PostDetail(
        PostMock.postMock.title,
        PostMock.postMock.body,
        UserMock.userMock.userName,
        CommentMock.commentListMock
    )

}