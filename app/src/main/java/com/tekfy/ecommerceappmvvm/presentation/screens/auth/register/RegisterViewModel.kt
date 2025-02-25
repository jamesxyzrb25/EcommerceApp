package com.tekfy.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor():ViewModel() {
    var state by mutableStateOf(RegisterState())

    var errorMessage by mutableStateOf("")
        private set

    fun onNameInput(input:String){
        state = state.copy(name = input)
    }
    fun onLastnameInput(input:String){
        state = state.copy(lastName = input)
    }
    fun onEmailInput(input:String){
        state = state.copy(email = input)
    }
    fun onPhoneInput(input:String){
        state = state.copy(phone = input)
    }
    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }
    fun onConfirmPasswordInput(input:String){
        state = state.copy(confirmPassword = input)
    }

    fun validateForm() = viewModelScope.launch {
        if(state.name == ""){
            errorMessage = "Ingresa al nombre"
        }
        else if(state.lastName == ""){
            errorMessage = "Ingresa el apellido"
        }
        else if(state.phone == ""){
            errorMessage = "Ingresa el telefono"
        }
        else if(state.email == ""){
            errorMessage = "Ingresa el email"
        }
        else if(state.password == ""){
            errorMessage = "Ingresa el password"
        }
        else if(state.confirmPassword == ""){
            errorMessage = "Ingresa el password de confirmacion"
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
        }
        else if(state.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
        }
        else if(state.password != state.confirmPassword){
            errorMessage= "Las contraseñas no coinciden"
        }

        delay(3000)
        errorMessage = ""
    }
}