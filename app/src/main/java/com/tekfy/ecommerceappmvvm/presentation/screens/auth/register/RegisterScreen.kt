package com.tekfy.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tekfy.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.LoginScreen
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterContent
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme

@Composable
fun RegisterScreen(navController:NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title ="Registro",
                upAvailable = true,
                navController = navController
            )
        },
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    EcommerceAppMVVMTheme {
        //Greeting("Android")
        //LoginContent()
        RegisterScreen(rememberNavController())
    }
}