package com.vinaymj.news.headline.data.repository

import com.vinaymj.news.headline.data.api.NewsService
import com.vinaymj.news.headline.domain.model.News
import com.vinaymj.news.headline.domain.repository.NewsRepository
import com.vinaymj.news.core.api.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
): NewsRepository {
    override suspend fun getTopHeadlines(countryCode: String, page: Int): Response<News> {
        val response = newsService.getTopHeadlines(countryCode, page)
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Response.Success(result)
            }
        }
        return Response.Error(response.message())
    }
}