package com.ymlct.hometaskcleanarch.data.di

import android.content.Context
import android.content.SharedPreferences
import com.ymlct.hometaskcleanarch.data.repository.RepositoryImpl
import com.ymlct.hometaskcleanarch.data.repository.local.LocalRepository
import com.ymlct.hometaskcleanarch.data.repository.local.LocalRepositoryImpl
import com.ymlct.hometaskcleanarch.data.utils.APP_PREFERENCES_NAME
import com.ymlct.hometaskcleanarch.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext appContext: Context
    ): SharedPreferences {
        return appContext
            .getSharedPreferences(
                APP_PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
    }

    @Provides
    @Singleton
    fun provideLocalRepository(
        sharedPreferences: SharedPreferences
    ): LocalRepository {
        return LocalRepositoryImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideRepository(
        localRepository: LocalRepository
    ): Repository {
        return RepositoryImpl(localRepository)
    }
}