package com.harshcode.newsly.di

import android.app.Application
import com.harshcode.newsly.data.manager.LocalUserManagerImpl
import com.harshcode.newsly.data.remote.NewsApi
import com.harshcode.newsly.data.repository.NewsRepositoryImpl
import com.harshcode.newsly.domain.manager.LocalUserManager
import com.harshcode.newsly.domain.repository.NewsRepository
import com.harshcode.newsly.domain.usecases.app_entry.AppEntryUseCases
import com.harshcode.newsly.domain.usecases.app_entry.ReadAppEntry
import com.harshcode.newsly.domain.usecases.app_entry.SaveAppEntry
import com.harshcode.newsly.domain.usecases.news.GetNews
import com.harshcode.newsly.domain.usecases.news.NewsUseCases
import com.harshcode.newsly.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(userManager = localUserManager),
        saveAppEntry = SaveAppEntry(userManager = localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository =
        NewsRepositoryImpl(newsApi = newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository) = NewsUseCases(
        getNews = GetNews(newsRepository = newsRepository)
    )
}