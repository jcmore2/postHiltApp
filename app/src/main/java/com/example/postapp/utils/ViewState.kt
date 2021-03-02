package com.example.postapp.utils

sealed class ViewState<out T> {
    object Loading: ViewState<Nothing>()
    object Error: ViewState<Nothing>()
    data class Content<T>(val data: T): ViewState<T>()
}