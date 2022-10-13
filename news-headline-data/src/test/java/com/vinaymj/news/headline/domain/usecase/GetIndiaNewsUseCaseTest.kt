package com.vinaymj.news.headline.domain.usecase

import com.vinaymj.news.headline.data.TestUtils
import com.vinaymj.news.headline.data.api.NewsService
import com.vinaymj.news.headline.data.repository.NewsRepositoryImpl
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class GetIndiaNewsUseCaseTest {

    private lateinit var getIndiaNewsUseCase: GetIndiaNewsUseCase

    private lateinit var service: NewsService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
        getIndiaNewsUseCase = GetIndiaNewsUseCase(NewsRepositoryImpl(service))
    }

    @After
    fun tearDown() {
        server.shutdown()
    }


    @Test
    fun `get india headline news - success`() = runBlocking {
        val mockResponseObject = TestUtils.getMockResponseObject(
            fileName = "in_top_headline.json", responseCode = 200
        )
        server.enqueue(mockResponseObject)
        val response = getIndiaNewsUseCase.execute("in", 1)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.data?.totalResults, 38)
    }

    @Test
    fun `get india headline news - fail`() = runBlocking {
        val mockResponseObject = TestUtils.getMockResponseObject(
            fileName = "error.json", responseCode = 500
        )
        server.enqueue(mockResponseObject)
        val response = getIndiaNewsUseCase.execute("in", 1)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.errorMessage, "Server Error")
    }
}