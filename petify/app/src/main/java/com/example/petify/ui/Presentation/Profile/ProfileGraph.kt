package com.example.petify.ui.Presentation.Profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.Presentation.Login.LoginVM
import com.example.petify.ui.Presentation.Login.User

@Composable
fun ProfileGraph(
    vm: LoginVM,
    user: User,
    navControllerGlobal: NavController
) {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            ProfileHome(user = user, vm = vm, navController = navController, navControllerGlobal = navControllerGlobal )
        }
        composable("pro"){
                ProfileProSub(vm=vm,navController = navController,user=user)
        }
    }
}