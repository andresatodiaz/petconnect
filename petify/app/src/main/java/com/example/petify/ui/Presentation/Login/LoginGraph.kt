package com.example.petify.ui.Presentation.Login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginGraph(
    vm: LoginVM,
    navControllerGlobal: NavController,
    login:MutableState<Boolean>
){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "login" ){
        composable("login"){
            LoginHome(vm=vm,navControllerGlobal=navControllerGlobal,login=login, navController = navController)
        }
        composable("register"){
            Register(vm=vm,navController=navController)
        }
    }
}