package com.vinaymj.news.headline.data.repository

import com.vinaymj.news.headline.data.TestUtils
import com.vinaymj.news.headline.data.api.NewsService
import com.vinaymj.news.headline.domain.repository.NewsRepository
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryImplTest {

    private lateinit var service: NewsService
    private lateinit var repositoryImpl: NewsRepository
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
        repositoryImpl = NewsRepositoryImpl(service)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }


    @Test
    fun `get top headline news`() = runBlocking {
        server.enqueue(TestUtils.mockResponse("uk_top_headline.json"))
        val topHeadlines = repositoryImpl.getTopHeadlines("in", 1)

        Assert.assertNotNull(topHeadlines)
    }

    @Test
    fun `get top headline news fail`() = runBlocking {
        server.enqueue(TestUtils.mockResponse("error.json"))
        val topHeadlines = repositoryImpl.getTopHeadlines("in", 1)
        Assert.assertEquals(topHeadlines.data?.status, "error")
    }

}