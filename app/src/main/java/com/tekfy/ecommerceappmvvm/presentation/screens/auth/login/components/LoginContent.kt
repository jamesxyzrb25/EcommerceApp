package com.tekfy.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tekfy.ecommerceappmvvm.R
import com.tekfy.ecommerceappmvvm.presentation.components.DefaultButton
import com.tekfy.ecommerceappmvvm.presentation.components.DefaultTextField
import com.tekfy.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.Blue700

@Composable
fun LoginContent(paddingValues: PaddingValues, navController:NavHostController, vm:LoginViewModel= hiltViewModel()){
    val state = vm.state
    val context = LocalContext.current
    LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage!=  ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()){
        Image(
            modifier = Modifier.fillMaxSize(),
            //modifier = Modifier
            //.height(200.dp)
            //.width(150.dp),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f,0.5f,0.5f,1f)
            })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo"
            )
            Text(
                modifier = Modifier.padding(top=7.dp),
                text = "Ecommerce App",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Ingresar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    /*OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Correo electronico")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email icon",
                                tint = Blue500
                            )
                        },
                        *//*colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        )*//*
                    )*/
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                            vm.onEmailInput(it)
                        },
                        label ="Correo electronico" ,
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value =state.password,
                        onValueChange = {
                            vm.onPasswordInput(it)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    /*OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Contraseña")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Password icon",
                                tint = Blue500
                            )
                        },
                        *//*colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        )*//*
                    )*/
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        //    .padding(top = 20.dp) ,
                        text ="Login" ,
                        onClick = {
                            vm.login()
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    /*Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        onClick = { *//*TODO*//* }) {
                        Text(text = "Login")
                    }*/
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "No tienes cuenta}")
                        Spacer(modifier = Modifier.padding(6.dp))
                        Text(
                            modifier = Modifier.clickable { navController.navigate(route= AuthScreen.Register.route) },
                            text = "Registrate", color = Blue700
                        )
                    }
                }
            }
        }

    }
}