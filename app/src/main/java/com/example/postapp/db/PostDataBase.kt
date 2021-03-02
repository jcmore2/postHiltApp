package com.example.postapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.postapp.model.local.CommentLocalDTO
import com.example.postapp.model.local.PostLocalDTO
import com.example.postapp.model.local.UserLocalDTO


@Database(entities = [PostLocalDTO::class, UserLocalDTO::class, CommentLocalDTO::class], version = 1, exportSchema = false)
abstract class PostDataBase: RoomDatabase() {

    abstract val postDAO: PostDAO
    abstract val commentDAO: CommentDAO
    abstract val userDAO: UserDAO

    companion object {
        @Volatile
        private var INSTANCE: PostDataBase? = null
        fun getInstance(context: Context): PostDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PostDataBase::class.java,
                        "Posts"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}