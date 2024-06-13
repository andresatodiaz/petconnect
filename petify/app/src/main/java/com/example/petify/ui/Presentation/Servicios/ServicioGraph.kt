package com.example.petify.ui.Presentation.Servicios

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.Presentation.Login.User

@Composable
fun ServicioGraph(
    vm:ServiciosVM,
    user: User
){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            ServiciosHome(vm = vm,navController=navController,user=user)
        }
        composable("detail"){
            ServiciosDetail(servicioItem = vm.selectedItem.value)
        }
        composable("add"){
            ServicioNuevo(vm = vm, navController = navController, user = user)
        }
    }
}