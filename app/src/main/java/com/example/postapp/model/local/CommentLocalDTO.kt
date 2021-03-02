package com.example.postapp.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CommentLocalDTO(
    val postId: Int,
    @PrimaryKey val id: Int,
    val name: String,
    val email: String,
    val body: String
)