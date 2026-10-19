package com.harshcode.newsly.di

import android.app.Application
import com.harshcode.newsly.data.manager.LocalUserManagerImpl
import com.harshcode.newsly.domain.manager.LocalUserManager
import com.harshcode.newsly.domain.usecases.AppEntryUseCases
import com.harshcode.newsly.domain.usecases.ReadAppEntry
import com.harshcode.newsly.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}