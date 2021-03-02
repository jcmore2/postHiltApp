package com.example.postapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.postapp.screen.detail.DetailViewModel
import com.example.postapp.screen.main.MainViewModel
import com.example.postapp.usecase.GetPostDetailsUseCase
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
class DetailViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var getPostDetailsUseCase: GetPostDetailsUseCase
    private lateinit var detailViewModel: DetailViewModel

    private val postDetail = PostDetailMock.postDetailMock

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        getPostDetailsUseCase = Mockito.mock(GetPostDetailsUseCase::class.java)
        detailViewModel = DetailViewModel(getPostDetailsUseCase)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `checks viewState is not empty when request is not null`() = runBlocking {
        whenever(getPostDetailsUseCase.requestWithParameter(1)).thenReturn(postDetail)
        detailViewModel.initialize(1)
        Truth.assertThat(detailViewModel.viewState.value).isEqualTo(ViewState.Content(postDetail))
    }

    @Test
    fun `checks viewState is error when request is null`() = runBlocking {
        whenever(getPostDetailsUseCase.requestWithParameter(1)).thenReturn(null)
        detailViewModel.initialize(1)
        Truth.assertThat(detailViewModel.viewState.value).isEqualTo(ViewState.Error)
    }

}