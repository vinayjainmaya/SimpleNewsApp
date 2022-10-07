package com.vinaymj.news.headline.data.api

import com.vinaymj.news.headline.data.TestUtils.Companion.mockResponse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vinaymj on 07/10/22.
 */
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
    fun `get uk top headlines news`() = runBlocking {
        server.enqueue(mockResponse("uk_top_headline.json"))
        val responseBody = service.getTopHeadlines("uk", 1)
        val request = server.takeRequest()
        assertNotNull(responseBody.body())
        assertEquals(responseBody.body()?.totalResults, 38)
        assertEquals(
            "/v2/top-headlines?country=uk&page=1&apiKey=%3CNEWS_API_KEY%3E",
            request.path)
    }

    @Test
    fun `get india top headlines news`() = runBlocking {
        server.enqueue(mockResponse("in_top_headline.json"))
        val responseBody = service.getTopHeadlines("in", 1)
        val request = server.takeRequest()
        assertNotNull(responseBody.body())
        assertEquals(responseBody.body()?.totalResults, 38)
        assertEquals(
            "/v2/top-headlines?country=in&page=1&apiKey=%3CNEWS_API_KEY%3E",
            request.path)
    }


    @Test
    fun `empty country param`() = runBlocking {
        server.enqueue(mockResponse("error_empty_country.json"))
        val responseBody = service.getTopHeadlines("", 1)
        assertEquals(responseBody.body()?.status, "ok")
        assertEquals(responseBody.body()?.totalResults, 0)
        assertEquals(responseBody.body()?.articles?.size, 0)
    }

}