package com.vinaymj.news.headline.data.api

import com.vinaymj.news.headline.data.BuildConfig
import com.vinaymj.news.headline.domain.model.News
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by vinaymj on 06/10/22.
 */
interface NewsService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY) : retrofit2.Response<News>

}