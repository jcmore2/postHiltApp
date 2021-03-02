package com.example.postapp.injection

import com.example.postapp.client.RemoteDataSource
import com.example.postapp.db.RoomDataSource
import com.example.postapp.repository.Repository
import com.example.postapp.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun repository(
        remoteDataSource: RemoteDataSource,
        roomDataSource: RoomDataSource
    ): Repository =
        RepositoryImpl(remoteDataSource, roomDataSource)
}