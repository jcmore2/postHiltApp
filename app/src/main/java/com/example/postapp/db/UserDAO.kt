package com.example.postapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.model.local.UserLocalDTO

@Dao
interface UserDAO {

    @Query("SELECT * FROM UserLocalDTO WHERE id = :userId")
    suspend fun getUserById(userId: Int): UserLocalDTO?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserLocalDTO)
}