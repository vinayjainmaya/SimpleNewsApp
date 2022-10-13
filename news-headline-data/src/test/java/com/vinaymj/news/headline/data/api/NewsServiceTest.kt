package com.vinaymj.news.headline.data.api

import com.vinaymj.news.core.utils.Constants.Companion.API_KEY
import com.vinaymj.news.headline.data.TestUtils
import junit.framework.TestCase.*
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsServiceTest {

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
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `get uk top headlines news - success`() = runBlocking {
        val mockResponseObject = TestUtils.getMockResponseObject(
            fileName = "uk_top_headline.json", responseCode = 200
        )
        server.enqueue(mockResponseObject)
        val responseBody = service.getTopHeadlines("uk", 1)
        val request = server.takeRequest()
        assertNotNull(responseBody.body())
        assertEquals(responseBody.body()?.totalResults, 38)
        assertEquals(
            "/v2/top-headlines?country=uk&page=1&apiKey=${API_KEY}",
            request.path)
    }

    @Test
    fun `get india top headlines news - success`() = runBlocking {
        val mockResponseObject = TestUtils.getMockResponseObject(
            fileName = "in_top_headline.json", responseCode = 200
        )
        server.enqueue(mockResponseObject)
        val responseBody = service.getTopHeadlines("in", 1)
        val request = server.takeRequest()
        assertNotNull(responseBody.body())
        assertEquals(responseBody.body()?.totalResults, 38)
        assertEquals(
            "/v2/top-headlines?country=in&page=1&apiKey=${API_KEY}",
            request.path)
    }


    @Test
    fun `empty country param`() = runBlocking {
        val mockResponseObject = TestUtils.getMockResponseObject(
            fileName = "error_empty_country.json", responseCode = 200
        )
        server.enqueue(mockResponseObject)

        val responseBody = service.getTopHeadlines("", 1)
        assertTrue(responseBody.isSuccessful)
        assertEquals(responseBody.body()?.status, "ok")
        assertEquals(responseBody.body()?.totalResults, 0)
        assertEquals(responseBody.body()?.articles?.size, 0)
    }

    @Test
    fun `get top headlines news - fail`() = runBlocking {
        val mockResponseObject = TestUtils.getMockResponseObject(
            fileName = "in_top_headline.json", responseCode = 500
        )
        server.enqueue(mockResponseObject)

        val responseBody = service.getTopHeadlines("in", 1)
        assertFalse(responseBody.isSuccessful)
        assertEquals(responseBody.message(), "Server Error")
    }

}