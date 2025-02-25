package com.tekfy.ecommerceappmvvm.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tekfy.ecommerceappmvvm.presentation.navigation.Graph
import com.tekfy.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.LoginScreen
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }
    }
}