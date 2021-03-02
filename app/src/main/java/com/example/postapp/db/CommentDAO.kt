package com.example.postapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.model.local.CommentLocalDTO

@Dao
interface CommentDAO {

    @Query("SELECT * FROM CommentLocalDTO WHERE postId = :postId")
    suspend fun getCommentsFromPost(postId: Int): List<CommentLocalDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: CommentLocalDTO)
}