package com.vinaymj.news.headline.domain.usecase

import com.vinaymj.news.core.api.Response
import com.vinaymj.news.headline.domain.mockUkTopHeadline
import com.vinaymj.news.headline.domain.repository.NewsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetIndiaNewsUseCaseTest {

    private lateinit var getIndiaNewsUseCase: GetIndiaNewsUseCase

    @MockK
    private lateinit var repository: NewsRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getIndiaNewsUseCase = GetIndiaNewsUseCase(repository)
    }


    @Test
    fun `get india headline news - success`() = runBlocking {
        coEvery { repository.getTopHeadlines(any(),any()) } returns Response.Success(
            mockUkTopHeadline)

        val response = getIndiaNewsUseCase.execute("in", 1)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.data?.totalResults, 2)
    }

    @Test
    fun `get india headline news - fail`() = runBlocking {
        coEvery { repository.getTopHeadlines(any(),any()) } returns Response.Error("Server Error")
        val response = getIndiaNewsUseCase.execute("in", 1)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.errorMessage, "Server Error")
    }
}