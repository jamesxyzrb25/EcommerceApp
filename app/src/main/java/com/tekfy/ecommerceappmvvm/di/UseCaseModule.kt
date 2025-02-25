package com.tekfy.ecommerceappmvvm.di

import com.tekfy.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.tekfy.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.tekfy.ecommerceappmvvm.data.service.AuthService
import com.tekfy.ecommerceappmvvm.domain.repository.AuthRepository
import com.tekfy.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.tekfy.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository)
    )
}