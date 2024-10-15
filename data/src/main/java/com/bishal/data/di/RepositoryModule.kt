package com.bishal.data.di

import com.bishal.data.repository.CurrentWeatherRepository
import com.bishal.data.repository.CurrentWeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideCurrentWeatherRepo(impl : CurrentWeatherRepositoryImpl) : CurrentWeatherRepository

}