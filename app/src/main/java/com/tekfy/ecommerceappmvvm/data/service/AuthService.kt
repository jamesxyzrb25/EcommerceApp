package com.tekfy.ecommerceappmvvm.data.service

import com.tekfy.ecommerceappmvvm.domain.models.AuthResponse
import com.tekfy.ecommerceappmvvm.domain.models.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    //http://192.168.18.6:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String,
    ):Response<User>

}