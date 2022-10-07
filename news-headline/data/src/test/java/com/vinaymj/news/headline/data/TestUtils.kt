package com.vinaymj.news.headline.data

import okhttp3.mockwebserver.MockResponse
import okio.buffer
import okio.source

/**
 * Created by vinaymj on 07/10/22.
 */
class TestUtils {

    companion object {
        fun mockResponse(fileName: String): MockResponse {
            val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
            val source = inputStream?.source()?.buffer()
            val mockResponse = MockResponse()
            source?.readString(Charsets.UTF_8)?.let { mockResponse.setBody(it) }
            return mockResponse
        }
    }
}