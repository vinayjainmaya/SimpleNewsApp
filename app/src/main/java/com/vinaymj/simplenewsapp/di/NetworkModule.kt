package com.vinaymj.simplenewsapp.di

import com.vinaymj.news.headline.data.api.NewsService
import com.vinaymj.news.headline.data.repository.NewsRepositoryImpl
import com.vinaymj.news.headline.domain.repository.NewsRepository
import com.vinaymj.simplenewsapp.core.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by vinaymj on 06/10/22.
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }

    @Provides
    fun provideNewsRepository(newsRepo: NewsRepositoryImpl): NewsRepository {
        return newsRepo
    }
}