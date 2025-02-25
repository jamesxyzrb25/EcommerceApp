package com.tekfy.ecommerceappmvvm.domain.repository

import com.tekfy.ecommerceappmvvm.domain.models.User


interface AuthRepository {
    //Utilizar las corrutinas por eso es suspendida
    suspend fun login(email:String, password:String): Result<User>
}