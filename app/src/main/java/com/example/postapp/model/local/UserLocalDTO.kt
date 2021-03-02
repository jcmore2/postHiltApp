package com.example.postapp.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLocalDTO (
    @PrimaryKey val id: Int,
    val name: String,
    val userName: String,
    val email: String,
    val phone: String,
    val website: String
)