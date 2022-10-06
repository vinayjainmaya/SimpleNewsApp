package com.vinaymj.simplenewsapp.data.repository

import com.vinaymj.simplenewsapp.data.api.Response
import com.vinaymj.simplenewsapp.data.api.NewsService
import com.vinaymj.simplenewsapp.data.model.News
import com.vinaymj.simplenewsapp.domain.repository.NewsRepository
import javax.inject.Inject

/**
 * Created by vinaymj on 06/10/22.
 */
class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService): NewsRepository {
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