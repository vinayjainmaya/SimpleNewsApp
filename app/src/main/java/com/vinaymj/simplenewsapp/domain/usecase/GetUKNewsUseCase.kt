package com.vinaymj.simplenewsapp.domain.usecase

import com.vinaymj.simplenewsapp.data.api.Response
import com.vinaymj.simplenewsapp.data.model.News
import com.vinaymj.simplenewsapp.domain.repository.NewsRepository
import javax.inject.Inject

/**
 * Created by vinaymj on 06/10/22.
 */
class GetUKNewsUseCase @Inject constructor(private val repository: NewsRepository) {
    suspend fun execute(countryCode: String, page: Int = 1): Response<News> {
        return repository.getTopHeadlines(countryCode, page)
    }
}