package com.vinaymj.news.headline.domain.usecase

import com.vinaymj.news.headline.domain.model.News
import com.vinaymj.news.headline.domain.repository.NewsRepository
import com.vinaymj.simplenewsapp.core.api.Response
import javax.inject.Inject

/**
 * Created by vinaymj on 06/10/22.
 */
class GetUKNewsUseCase @Inject constructor(private val repository: NewsRepository) {
    suspend fun execute(countryCode: String, page: Int = 1): Response<News> {
        return repository.getTopHeadlines(countryCode, page)
    }
}