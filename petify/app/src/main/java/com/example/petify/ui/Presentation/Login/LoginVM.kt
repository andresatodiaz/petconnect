package com.example.petify.ui.Presentation.Login

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor():ViewModel() {

    val users = mutableStateListOf<User>(
        User(
            nombre = "Gabo Lopez",
            correo = "gabo.lopez@gmail.com",
            contrasena = "gabo1",
            numero = 936779244,
        )
    )
    val loggedUser= mutableStateOf(
        users[0]
    )

    fun login(correo:String, contrasena:String,navController: NavController,login:MutableState<Boolean>){
        Log.i("user",users.toList().toString())
        val tempUser=users.find { user->
            (user.correo==correo && user.contrasena==contrasena)
        }
        if(tempUser!=null){
            loggedUser.value=tempUser
            login.value=false
            navController.navigate("servicios")
        }
    }

    fun logout(){
        loggedUser.value=User()
    }

    fun register(user: User,navController: NavController){
        if(!users.contains(user)
            && user.correo!=""
            && user.contrasena!=""
            && user.numero!=0
            && user.nombre!=""
            ){
            users.add(user)
            navController.navigate("login")
        }
    }

    fun turnPro(user:User,navController: NavController){
        users.forEach {userItem->
            if(userItem.correo==user.correo && userItem.contrasena==user.contrasena){
                userItem.pro.value = !userItem.pro.value
            }
        }
        Log.i("loggedPro",users.toString())

        navController.navigate("home")
    }
}