package com.example.postapp.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostLocalDTO(
    val userId: Int,
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
)