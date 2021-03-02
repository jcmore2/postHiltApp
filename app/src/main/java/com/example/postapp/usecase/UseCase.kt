package com.example.postapp.usecase

interface UseCase<T> {

    suspend fun request(): T

}