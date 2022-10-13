package com.vinaymj.news.headline.domain.repository

import com.vinaymj.news.headline.domain.model.News
import com.vinaymj.news.core.api.Response

interface NewsRepository {

    suspend fun getTopHeadlines(countryCode: String, page: Int) : Response<News>

}