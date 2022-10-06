package com.vinaymj.news.headline.domain.repository

import com.vinaymj.news.headline.domain.model.News
import com.vinaymj.simplenewsapp.core.api.Response

/**
 * Created by vinaymj on 06/10/22.
 */
interface NewsRepository {

    suspend fun getTopHeadlines(countryCode: String, page: Int) : Response<News>

}