package com.example.postapp.injection

import com.example.postapp.client.RetrofitDataSource
import com.example.postapp.db.RoomDataSource
import com.example.postapp.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun repository(retrofitDataSource: RetrofitDataSource,
                   roomDataSource: RoomDataSource
    ): RepositoryImpl =
        RepositoryImpl(retrofitDataSource, roomDataSource)
}