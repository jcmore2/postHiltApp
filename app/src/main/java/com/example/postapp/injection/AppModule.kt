package com.example.postapp.injection

import android.content.Context
import com.example.postapp.PostApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: PostApp) {

    @Provides
    @Singleton
    fun context(): Context = app.applicationContext

}