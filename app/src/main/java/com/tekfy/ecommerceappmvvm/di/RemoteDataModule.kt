package com.tekfy.ecommerceappmvvm.di

import com.tekfy.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.tekfy.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.tekfy.ecommerceappmvvm.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService):AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)
}