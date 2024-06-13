package com.example.petify.ui.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petify.ui.Presentation.Adopcion.AdopcionGraph
import com.example.petify.ui.Presentation.Adopcion.AdopcionScreen
import com.example.petify.ui.Presentation.Adopcion.AdopcionVM
import com.example.petify.ui.Presentation.Alertas.AlertaGraph
import com.example.petify.ui.Presentation.Alertas.AlertaVM
import com.example.petify.ui.Presentation.Emergencias.EmergenciaGraph
import com.example.petify.ui.Presentation.Emergencias.EmergenciaVM
import com.example.petify.ui.Presentation.Login.LoginGraph
import com.example.petify.ui.Presentation.Login.LoginVM
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.Presentation.Profile.ProfileGraph
import com.example.petify.ui.Presentation.Servicios.ServicioGraph
import com.example.petify.ui.Presentation.Servicios.ServiciosVM

@Composable
fun NavigationGraph(
    navController: NavHostController,
    serviciosVM: ServiciosVM= hiltViewModel(),
    emergenciaVM: EmergenciaVM= hiltViewModel(),
    alertaVM: AlertaVM= hiltViewModel(),
    adopcionVM: AdopcionVM= hiltViewModel(),
    loginVM: LoginVM= hiltViewModel(),
    login:MutableState<Boolean>,
    loggedUser:MutableState<User>
){
    LaunchedEffect(key1 = loginVM.loggedUser.value){
        loggedUser.value=loginVM.loggedUser.value
        Log.i("logged",loggedUser.value.toString())
    }
    NavHost(navController = navController, startDestination = "servicios"){
        composable("servicios"){
            ServicioGraph(serviciosVM,user=loginVM.loggedUser.value)
        }
        composable("adopcion"){
            AdopcionGraph(vm = adopcionVM,user=loginVM.loggedUser.value)
        }
        composable("emergencias"){
            EmergenciaGraph(emergenciaVM,user=loginVM.loggedUser.value)
        }
        composable("alertas"){
            AlertaGraph(alertaVM,user=loginVM.loggedUser.value)
        }
        composable("perfil"){
            ProfileGraph(vm=loginVM,user=loginVM.loggedUser.value,navController)
        }
        composable("login"){
            LoginGraph(vm = loginVM,login=login, navControllerGlobal = navController)
        }
    }
}