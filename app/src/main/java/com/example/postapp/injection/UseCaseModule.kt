package com.example.postapp.injection

import com.example.postapp.repository.Repository
import com.example.postapp.usecase.GetAllPostsUseCase
import com.example.postapp.usecase.GetPostDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun getAllPostsUseCase(repository: Repository): GetAllPostsUseCase =
        GetAllPostsUseCase(repository)

    @Provides
    fun getPostDetailsUseCase(repository: Repository): GetPostDetailsUseCase =
        GetPostDetailsUseCase(repository)


}