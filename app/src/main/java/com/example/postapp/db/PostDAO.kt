package com.example.postapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.model.local.PostLocalDTO

@Dao
interface PostDAO {

    @Query("SELECT * FROM PostLocalDTO")
    suspend fun getAll(): List<PostLocalDTO>

    @Query("SELECT * FROM PostLocalDTO WHERE id = :postId")
    suspend fun getPostById(postId: Int): PostLocalDTO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostLocalDTO)
}