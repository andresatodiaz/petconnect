package com.example.petify.ui.Presentation.Adopcion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.Presentation.Login.User

@Composable
fun AdopcionGraph(
    vm:AdopcionVM,
    user:User
) {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            AdopcionScreen(vm = vm,navController=navController,user=user)
        }
        composable("list"){
            AdopcionList(vm=vm,user=user,navController=navController)
        }
        composable("add"){
            AdopcionNuevo(vm = vm, user = user, navController = navController)
        }
    }
}