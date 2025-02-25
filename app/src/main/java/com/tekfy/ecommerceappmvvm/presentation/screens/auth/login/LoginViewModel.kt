package com.tekfy.ecommerceappmvvm.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tekfy.ecommerceappmvvm.domain.models.AuthResponse
import com.tekfy.ecommerceappmvvm.domain.models.User
import com.tekfy.ecommerceappmvvm.domain.repository.Result
import com.tekfy.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.tekfy.ecommerceappmvvm.domain.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase:AuthUseCase):ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    /*var isValidForm by mutableStateOf(false)
        private set*/
    var errorMessage by mutableStateOf("")
        private set

    //login response
    var loginResponse by mutableStateOf<Result<User>?>(null)
        private set

    fun login() = viewModelScope.launch {
        if(isValidForm()){
            loginResponse = Result.Loading
            val result = authUseCase.login(state.email, state.password) // retorna respuesta
            loginResponse = result //exitosa / error
            Log.d("LoginViewModel","Response ${loginResponse}")
        }

    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }

    fun isValidForm():Boolean{
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false
        }
        else if(state.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }

        return true
        //delay(3000)
        //errorMessage = ""
    }


}