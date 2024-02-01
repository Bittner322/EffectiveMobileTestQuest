package com.mikhail.effectivemobiletestquest.di

import com.mikhail.effectivemobiletestquest.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideArticleDatabase(): AppDatabase = AppDatabase.INSTANCE
}