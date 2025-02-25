package com.tekfy.ecommerceappmvvm.presentation.screens.auth.register.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.tekfy.ecommerceappmvvm.R
import com.tekfy.ecommerceappmvvm.presentation.components.DefaultButton
import com.tekfy.ecommerceappmvvm.presentation.components.DefaultTextField
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(paddingValues: PaddingValues, vm:RegisterViewModel= hiltViewModel()){
    val state = vm.state
    val context = LocalContext.current
    LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage!=  ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()
    ){
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderBanner()
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.8f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 20.dp),
                        text = "REGISTRARSE",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = {
                                        vm.onNameInput(it)
                        },
                        label = "Nombres",
                        icon = Icons.Default.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastName,
                        onValueChange = {
                                        vm.onLastnameInput(it)
                        },
                        label = "Apellidos",
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                                        vm.onEmailInput(it)
                        },
                        label = "Correo electronico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = {
                                        vm.onPhoneInput(it)
                        },
                        label = "Telefono",
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Phone
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {
                                        vm.onPasswordInput(it)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange = {
                                        vm.onConfirmPasswordInput(it)
                        },
                        label = "Confirmar Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "CONFIRMAR",
                        onClick = { vm.validateForm() })
                }
            }
        }
    }
}

@Composable
fun BackgroundImage(){
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.banner_form),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
            setToScale(0.5f,0.5f,0.5f,1f)
        })
    )
}

@Composable
fun HeaderBanner(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            modifier = Modifier
                .height(80.dp)
                .width(80.dp),
            painter = painterResource(id = R.drawable.user_form),
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(top = 7.dp, start = 10.dp),
            text = "INGRESA ESTA INFORMACION",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}



