package com.tekfy.ecommerceappmvvm.domain.useCase.auth

import com.tekfy.ecommerceappmvvm.domain.repository.AuthRepository
//Los casos de uso solo ejecutan una accion
class LoginUseCase(private val repository: AuthRepository) {
    //Se dispara al momento de llamar al loginusecase
    suspend operator fun invoke(email:String, password:String) = repository.login(email,password)
}