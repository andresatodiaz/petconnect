package com.example.petify.ui.Presentation.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petify.ui.Presentation.Login.LoginVM
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown

@Composable
fun ProfileHome(
    user: User,
    vm: LoginVM,
    navController: NavController,
    navControllerGlobal: NavController
) {
    LazyColumn(modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item{
            Spacer(modifier = Modifier.padding(10.dp))
            Card(
                elevation=CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors=CardDefaults.cardColors(
                    containerColor = mainAmber,
                    contentColor = mainBrown
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable {
                        navController.navigate("pro")
                    }
            ) {
                Row(modifier=Modifier.padding(20.dp)) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = null)
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text="Subscripción premium", fontWeight = FontWeight.Bold)
                }
            }
        }
        item {
            Spacer(modifier = Modifier.padding(10.dp))
            Card(
                elevation=CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors=CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Row(modifier=Modifier.padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Face, contentDescription = null)
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text=user.nombre?:"")
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    if(user.pro?.value==true){
                        Row(
                            modifier=Modifier.background(mainAmber, CircleShape)
                        ){
                            Text(text = "Pro",modifier=Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.padding(10.dp))
            Card(
                elevation=CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors=CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable {
                        navControllerGlobal.navigate("login")
                        vm.logout()
                    }
            ) {
                Row(modifier=Modifier.padding(20.dp)) {
                    Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = null)
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text="Cerrar sesión")
                }
            }
        }
    }
}