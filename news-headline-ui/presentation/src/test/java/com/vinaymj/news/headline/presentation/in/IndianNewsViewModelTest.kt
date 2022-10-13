package com.vinaymj.news.headline.presentation.`in`

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vinaymj.news.core.api.Response
import com.vinaymj.news.headline.domain.usecase.GetIndiaNewsUseCase
import com.vinaymj.news.headline.presentation.topHeadline
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
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
    fun `get top headlines - success`() = runTest{
        coEvery { useCase.execute(any(), any()) } returns Response.Success(topHeadline)
        viewModel.news.observeForever {  }
        viewModel.getTopHeadlines("in")
        val job = launch (UnconfinedTestDispatcher()) {
            viewModel.getTopHeadlines("in")
        }
        job.join()
        Assert.assertTrue(viewModel.news.value != null)
        viewModel.news.value?.getContent()?.data?.apply {
            Assert.assertEquals(status, "ok")
            Assert.assertEquals(totalResults, 2)
        }
        io.mockk.coVerify(atLeast = 1) {useCase.execute(countryCode = "in", page = 1)}

        job.cancelAndJoin()
    }

    @Test
    fun `get top headlines - fail`() = runTest{
        coEvery { useCase.execute(any(), any()) } returns Response.Error("Server Error")
        viewModel.news.observeForever {  }
        viewModel.getTopHeadlines("in")
        val job = launch (UnconfinedTestDispatcher()) {
            viewModel.getTopHeadlines("in")
        }
        job.join()
        Assert.assertTrue(viewModel.news.value != null)
        Assert.assertTrue(viewModel.news.value?.getContent()?.data == null)
        Assert.assertEquals(viewModel.news.value?.getContent()?.errorMessage,"Server Error")
        io.mockk.coVerify(atLeast = 1) {useCase.execute(countryCode = "in", page = 1)}

        job.cancelAndJoin()
    }
}