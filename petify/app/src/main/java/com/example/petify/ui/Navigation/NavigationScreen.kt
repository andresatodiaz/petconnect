package com.example.petify.ui.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.Components.BottomBar
import com.example.petify.ui.Components.TopBar
import com.example.petify.ui.Presentation.Login.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen(){
    val navController= rememberNavController()
    val login= remember{ mutableStateOf(false) }
    val loggedUser= remember{ mutableStateOf(User()) }
    Scaffold(
        topBar = {
            if(!login.value){
                TopBar(user=loggedUser.value){
                    navController.navigate("perfil")
                }
            }
        },
        bottomBar = {
            if(!login.value){
                BottomBar(navController = navController)
            }
        }
    ) {paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)){
            NavigationGraph(navController = navController,login=login,loggedUser=loggedUser)
        }
    }
}