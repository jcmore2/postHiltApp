package com.example.postapp.screen.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.model.canon.Post
import com.example.postapp.usecase.GetAllPostsUseCase
import com.example.postapp.utils.ViewState
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainViewModel
@Inject constructor(private val getAllPostsUseCase: GetAllPostsUseCase) : ViewModel() {

    private val _viewState = MutableLiveData<ViewState<List<Post>>>()
    val viewState: LiveData<ViewState<List<Post>>>
        get() = _viewState

    init {
        loadData()
    }

    fun loadData() {
        _viewState.value = ViewState.Loading
        observeResponse()
    }

    private fun observeResponse() {
        viewModelScope.launch {
            try {
                val allPosts = getAllPostsUseCase.request()
                if (!allPosts.isNullOrEmpty())
                    _viewState.value = ViewState.Content(allPosts)
                else
                    _viewState.value = ViewState.Error
            } catch (e: Exception) {
                _viewState.value = ViewState.Error
            }
        }
    }
}