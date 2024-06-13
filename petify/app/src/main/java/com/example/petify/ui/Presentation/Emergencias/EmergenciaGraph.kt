package com.example.petify.ui.Presentation.Emergencias

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.Presentation.Login.User

@Composable
fun EmergenciaGraph(
    vm: EmergenciaVM,
    user: User
){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            EmergenciaHome(vm = vm,navController=navController,user=user)
        }
        composable("detail"){
            EmergenciaDetail(emergenciaItem = vm.selectedItem.value )
        }
        composable("add"){
            EmergenciaNuevo(vm = vm, navController = navController, user =user )
        }
    }
}