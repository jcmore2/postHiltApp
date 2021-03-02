package com.example.postapp.injection

import com.example.postapp.repository.RepositoryImpl
import com.example.postapp.usecase.GetAllPostsUseCase
import com.example.postapp.usecase.GetPostDetailsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getAllPostsUseCase(repositoryImpl: RepositoryImpl): GetAllPostsUseCase =
        GetAllPostsUseCase(repositoryImpl)

    @Provides
    fun getPostDetailsUseCase(repositoryImpl: RepositoryImpl): GetPostDetailsUseCase =
        GetPostDetailsUseCase(repositoryImpl)


}