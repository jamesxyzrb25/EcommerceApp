package com.tekfy.ecommerceappmvvm.domain.models

data class AuthResponse(
    val user:User,
    val token:String
)
