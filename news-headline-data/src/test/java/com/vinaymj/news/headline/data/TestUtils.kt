package com.vinaymj.news.headline.data

import okhttp3.mockwebserver.MockResponse
import okio.buffer
import okio.source

class TestUtils {

    companion object {
        fun readMockResponse(fileName: String): String? {
            val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
            val source = inputStream?.source()?.buffer()
            return source?.readString(Charsets.UTF_8)
        }

        fun getMockResponseObject(fileName: String, responseCode: Int): MockResponse {
            val mockResponse = MockResponse().setResponseCode(responseCode)
            readMockResponse(fileName)?.let {
                mockResponse.setBody(it)
            }
            return mockResponse
        }
    }
}