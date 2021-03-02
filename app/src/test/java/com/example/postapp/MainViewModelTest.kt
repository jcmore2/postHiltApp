package com.example.postapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.postapp.screen.main.MainViewModel
import com.example.postapp.usecase.GetAllPostsUseCase
import com.example.postapp.utils.ViewState
import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var getAllPostsUseCase: GetAllPostsUseCase
    private lateinit var mainViewModel: MainViewModel

    private val postList = PostMock.postListMock
    private val emptyPostList = PostMock.emptyPostList

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        getAllPostsUseCase = Mockito.mock(GetAllPostsUseCase::class.java)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `checks viewState is error when request is null`() = runBlocking {
        whenever(getAllPostsUseCase.request()).thenReturn(null)
        mainViewModel = MainViewModel(getAllPostsUseCase)
        Truth.assertThat(mainViewModel.viewState.value).isEqualTo(ViewState.Error)
    }

    @Test
    fun `checks viewState is error when request is empty`() = runBlocking {
        whenever(getAllPostsUseCase.request()).thenReturn(emptyPostList)
        mainViewModel = MainViewModel(getAllPostsUseCase)
        Truth.assertThat(mainViewModel.viewState.value).isEqualTo(ViewState.Error)
    }

    @Test
    fun `checks viewState is not empty when request is not empty`() = runBlocking {
        whenever(getAllPostsUseCase.request()).thenReturn(postList)
        mainViewModel = MainViewModel(getAllPostsUseCase)
        Truth.assertThat(mainViewModel.viewState.value).isEqualTo(ViewState.Content(postList))
    }
}