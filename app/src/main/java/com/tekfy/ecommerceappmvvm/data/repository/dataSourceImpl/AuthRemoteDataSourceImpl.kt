package com.tekfy.ecommerceappmvvm.data.repository.dataSourceImpl

import com.tekfy.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.tekfy.ecommerceappmvvm.data.service.AuthService
import com.tekfy.ecommerceappmvvm.domain.models.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService):AuthRemoteDataSource {

    override suspend fun login(email:String, password:String) = authService.login(email, password)
}