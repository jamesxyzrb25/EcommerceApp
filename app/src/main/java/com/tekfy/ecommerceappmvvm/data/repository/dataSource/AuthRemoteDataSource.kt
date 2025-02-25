package com.tekfy.ecommerceappmvvm.data.repository.dataSource

import com.tekfy.ecommerceappmvvm.domain.models.AuthResponse
import com.tekfy.ecommerceappmvvm.domain.models.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email:String, password:String): Response<User>
}