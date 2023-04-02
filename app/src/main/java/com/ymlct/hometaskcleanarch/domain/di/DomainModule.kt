package com.ymlct.hometaskcleanarch.domain.di

import com.ymlct.hometaskcleanarch.domain.repository.Repository
import com.ymlct.hometaskcleanarch.domain.usecases.ShouldSuggestRateAppUseCase
import com.ymlct.hometaskcleanarch.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            shouldSuggestRateAppUseCase = ShouldSuggestRateAppUseCase(repository),
        )
    }

}