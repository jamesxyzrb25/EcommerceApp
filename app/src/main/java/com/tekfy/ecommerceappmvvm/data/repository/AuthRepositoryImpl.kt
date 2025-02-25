package com.tekfy.ecommerceappmvvm.data.repository

import com.tekfy.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.tekfy.ecommerceappmvvm.domain.models.User
import com.tekfy.ecommerceappmvvm.domain.repository.AuthRepository
import com.tekfy.ecommerceappmvvm.domain.repository.Result



class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource):AuthRepository {

    override suspend fun login(email: String, password: String): Result<User> {
        return try{
            var result = authRemoteDataSource.login(email, password)
            Result.Success(result.body()!!)
        }catch (e:Exception){
            e.printStackTrace()
            Result.Failure(e)
        }
    }
    /*override suspend fun login(email: String, password: String): Response<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )*/

}