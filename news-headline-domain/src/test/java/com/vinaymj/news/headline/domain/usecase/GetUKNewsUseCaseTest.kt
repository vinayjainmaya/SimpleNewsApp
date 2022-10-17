package com.vinaymj.news.headline.domain.usecase

import com.vinaymj.news.core.api.Response
import com.vinaymj.news.headline.domain.mockUkTopHeadline
import com.vinaymj.news.headline.domain.repository.NewsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetUKNewsUseCaseTest {

    private lateinit var getUKNewsUseCase: GetUKNewsUseCase

    @MockK
    private lateinit var repository: NewsRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getUKNewsUseCase = GetUKNewsUseCase(repository)
    }

    @Test
    fun `get uk headline news - success`() = runBlocking {

        coEvery { repository.getTopHeadlines(any(),any()) } returns Response.Success(mockUkTopHeadline)

        val response = getUKNewsUseCase.execute("in", 1)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.data?.totalResults, 2)
    }

    @Test
    fun `get uk headline news - fail`() = runBlocking {

        coEvery { repository.getTopHeadlines(any(),any()) } returns Response.Error("Server Error")

        val response = getUKNewsUseCase.execute("in", 1)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.errorMessage, "Server Error")
    }
}