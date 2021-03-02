package com.example.postapp.usecase

interface UseCaseWithParameter<T, P> {
    suspend fun  requestWithParameter(p: P): T
}