package com.tekfy.ecommerceappmvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tekfy.ecommerceappmvvm.R
import com.tekfy.ecommerceappmvvm.presentation.navigation.graph.RootNavGraph
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.LoginScreen
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.Blue500
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.Blue700
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //LoginContent()
                    navController = rememberNavController()
                    RootNavGraph(navController = navController)
                    //LoginScreen()
                }
            }
        }
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    EcommerceAppMVVMTheme {
        //Greeting("Android")
        //LoginContent()
    }
}*/
