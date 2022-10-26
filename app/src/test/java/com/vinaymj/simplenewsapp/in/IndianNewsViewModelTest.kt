package com.vinaymj.simplenewsapp.`in`

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vinaymj.news.core.api.Response
import com.vinaymj.news.headline.domain.usecase.GetIndiaNewsUseCase
import com.vinaymj.simplenewsapp.getOrAwaitValue
import com.vinaymj.simplenewsapp.topHeadline
import com.vinaymj.simplenewsapp.ui.`in`.IndianNewsViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class IndianNewsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: IndianNewsViewModel

    @MockK
    private var useCase = mockk<GetIndiaNewsUseCase>()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = IndianNewsViewModel(useCase)
    }


    @Test
    fun `get top headlines - success`() = runTest {
        coEvery { useCase.execute(any(), any()) } returns Response.Success(topHeadline)
        viewModel.news.observeForever { }
        viewModel.getTopHeadlines("in")
        viewModel.news.getOrAwaitValue()
        Assert.assertTrue(viewModel.news.value != null)
        io.mockk.coVerify(atLeast = 1) { useCase.execute(countryCode = "in", page = 1) }
        viewModel.news.value?.getContent()?.data?.apply {
            Assert.assertEquals("ok", status)
            Assert.assertEquals(2, totalResults)
        }
    }

    @Test
    fun `get top headlines - fail`() = runTest {
        coEvery { useCase.execute(any(), any()) } returns Response.Error("Server Error")
        viewModel.news.observeForever { }
        viewModel.getTopHeadlines("in")
        viewModel.news.getOrAwaitValue()
        Assert.assertTrue(viewModel.news.value != null)
        Assert.assertTrue(viewModel.news.value?.getContent()?.data == null)
        io.mockk.coVerify(atLeast = 1) { useCase.execute(countryCode = "in", page = 1) }
        Assert.assertEquals("Server Error", viewModel.news.value?.getContent()?.errorMessage)
    }
}