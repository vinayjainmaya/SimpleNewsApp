package com.vinaymj.simplenewsapp.data.api

import com.vinaymj.simplenewsapp.BuildConfig
import com.vinaymj.simplenewsapp.data.model.News
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