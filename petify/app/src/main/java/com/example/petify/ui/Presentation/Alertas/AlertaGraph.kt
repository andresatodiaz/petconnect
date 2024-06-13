package com.example.petify.ui.Presentation.Alertas

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.Presentation.Login.User

@Composable
fun AlertaGraph(
    vm:AlertaVM,
    user: User
){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            AlertaHome(vm = vm, navController = navController,user=user)
        }
        composable("detail"){
            AlertaDetail(alertaItem = vm.selectedItem.value)
        }
        composable("add"){
            AlertaNuevo(vm = vm, navController = navController, user = user)
        }
    }
}