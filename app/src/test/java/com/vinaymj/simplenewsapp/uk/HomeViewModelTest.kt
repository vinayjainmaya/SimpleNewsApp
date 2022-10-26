package com.vinaymj.simplenewsapp.uk

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vinaymj.news.core.api.Response
import com.vinaymj.news.headline.domain.usecase.GetUKNewsUseCase
import com.vinaymj.simplenewsapp.getOrAwaitValue
import com.vinaymj.simplenewsapp.topHeadline
import com.vinaymj.simplenewsapp.ui.uk.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @MockK
    private var useCase = mockk<GetUKNewsUseCase>()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(useCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get top headlines - success`() = runTest{
        coEvery { useCase.execute(any(), any()) } returns Response.Success(topHeadline)
        viewModel.news.observeForever {  }
        viewModel.getTopHeadlines("uk")
        viewModel.news.getOrAwaitValue()
        Assert.assertTrue(viewModel.news.value != null)
        viewModel.news.value?.getContent()?.data?.apply {
            Assert.assertEquals(status, "ok")
            Assert.assertEquals(totalResults, 2)
        }
        coVerify(atLeast = 1) {useCase.execute(countryCode = "uk", page = 1)}
    }

    @Test
    fun `get top headlines - fail`() = runTest{
        coEvery { useCase.execute(any(), any()) } returns Response.Error("Server Error")
        viewModel.news.observeForever {  }
        viewModel.getTopHeadlines("uk")
        viewModel.news.getOrAwaitValue()
        Assert.assertTrue(viewModel.news.value != null)
        Assert.assertTrue(viewModel.news.value?.getContent()?.data == null)
        coVerify(atLeast = 1) {useCase.execute(countryCode = "uk", page = 1)}
        Assert.assertEquals(viewModel.news.value?.getContent()?.errorMessage,"Server Error")
    }
}