package com.vinaymj.simplenewsapp.domain.repository

import com.vinaymj.simplenewsapp.data.api.Response
import com.vinaymj.simplenewsapp.data.model.News

/**
 * Created by vinaymj on 06/10/22.
 */
interface NewsRepository {

    suspend fun getTopHeadlines(countryCode: String, page: Int) : Response<News>

}