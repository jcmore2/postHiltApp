package com.example.postapp

import android.app.Application
import com.example.postapp.injection.*

class PostApp : Application() {

    companion object {
        lateinit var mDaggerAppComponent: AppComponent
        fun daggerAppComponent(): AppComponent = mDaggerAppComponent
    }


    override fun onCreate() {
        super.onCreate()
        mDaggerAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule())
            .repositoryModule(RepositoryModule())
            .useCaseModule(UseCaseModule())
            .build()

    }
}