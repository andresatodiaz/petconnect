package com.example.petify.ui.Presentation.Adopcion

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Components.LocationItem
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.mainRed
import com.example.petify.ui.theme.secondaryAmber
import com.example.petify.ui.theme.secondaryBrown
import com.example.petify.ui.theme.tertiaryGray

@Composable
fun AdopcionList(
    vm:AdopcionVM,
    user: User,
    navController: NavController
){
    val myPets= remember{mutableStateOf(emptyList<AdopcionItem>())}
    val solicitudes=remember{ mutableStateOf(emptyList<AdopcionItem>()) }
    val toAdopt = remember { mutableStateOf(false) }

    LaunchedEffect(key1 =true ){
        myPets.value=vm.myPets(user)
        solicitudes.value=vm.showRequest(user)
    }
    Box {
        LazyColumn(
            modifier=Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding =  PaddingValues(bottom=100.dp)
        ){
            item{
                Row(
                    modifier=Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextButton(
                        onClick = { toAdopt.value=false }) {
                        Text(text = "Adoptar",color=if(!toAdopt.value) mainBrown else secondaryBrown, fontWeight = if(!toAdopt.value) FontWeight.Bold else FontWeight.Normal)
                    }
                    TextButton(
                        onClick = { toAdopt.value=true }) {
                        Text(text = "En adopción",color=if(toAdopt.value) mainBrown else secondaryBrown, fontWeight = if(toAdopt.value) FontWeight.Bold else FontWeight.Normal )
                    }
                }
            }
            if(toAdopt.value){
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.petlist), contentDescription = null,modifier=Modifier.size(20.dp))
                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                        Text("Mis mascotas en adopción")
                    }
                }
                if(solicitudes.value.isEmpty()){
                    item{
                        Card(
                            modifier= Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 20.dp),
                            colors=CardDefaults.cardColors(
                                containerColor = tertiaryGray,
                                contentColor = Color.DarkGray
                            )
                        ) {
                            Row(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 10.dp, vertical = 20.dp)) {
                                Icon(imageVector = Icons.Filled.Info, contentDescription = null)
                                Spacer(Modifier.padding(horizontal = 5.dp))
                                Text(text="No tiene mascotas en adopción")
                            }
                        }
                    }
                }else{
                    solicitudes.value.forEach {adopcion->
                        item {
                            Card(modifier= Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 20.dp),
                                colors=CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = mainBrown
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ){
                                Row(
                                    modifier= Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Row {
                                        Image(painter = painterResource(id = adopcion.imagen!!), contentDescription = null, contentScale = ContentScale.Crop,modifier= Modifier
                                            .size(100.dp)
                                            .clip(
                                                RoundedCornerShape(20.dp)
                                            ))
                                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                                        Column{
                                            Text(text=adopcion.nombre!!, fontWeight = FontWeight.Bold,modifier=Modifier.padding(bottom=10.dp))
                                            Row {
                                                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null )
                                                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                                                Text(text = adopcion.autor?.nombre!!)
                                            }
                                            Spacer(Modifier.padding(vertical = 5.dp))
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Image(painter = painterResource(id = R.drawable.gmaps), contentDescription = null,modifier= Modifier.size(20.dp))
                                                Spacer(modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp))
                                                Text("A ${adopcion.distancia} km", fontWeight = FontWeight.Bold)
                                                Spacer(modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp))
                                                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription =null)
                                            }
                                        }
                                    }
                                    Icon(imageVector = Icons.Filled.Phone, contentDescription = null,tint= mainBrown)
                                }
                            }
                            Row(modifier= Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 20.dp)) {
                                Icon(imageVector = Icons.Filled.Face, contentDescription = null )
                                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                                Text(text="Solicitudes")
                            }
                            if (adopcion.interesados.isNullOrEmpty()){
                                Card(
                                    modifier= Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(top = 20.dp),
                                    colors=CardDefaults.cardColors(
                                        containerColor = tertiaryGray,
                                        contentColor = Color.DarkGray
                                    )
                                ) {
                                    Row(
                                        Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = 10.dp, vertical = 20.dp)) {
                                        Icon(imageVector = Icons.Filled.Info, contentDescription = null)
                                        Spacer(Modifier.padding(horizontal = 5.dp))
                                        Text(text="No tiene solicitudes")
                                    }
                                }
                            }else if(adopcion.interesados.isNotEmpty()){
                                adopcion.interesados.forEach {user->
                                    Card(modifier= Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(top = 20.dp),
                                        colors=CardDefaults.cardColors(
                                            containerColor = Color.White,
                                            contentColor = mainBrown
                                        ),
                                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                                    ){
                                        Row(
                                            modifier= Modifier
                                                .fillMaxWidth()
                                                .padding(20.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ){
                                            Column(modifier=Modifier.fillMaxWidth(0.7f)) {
                                                Row {
                                                    Icon(imageVector = Icons.Filled.Info, contentDescription =null )
                                                    Spacer(Modifier.padding(horizontal = 4.dp))
                                                    Text(text = user.nombre!!)
                                                }
                                                Spacer(Modifier.padding(vertical = 4.dp))
                                                Row {
                                                    Icon(imageVector = Icons.Filled.MailOutline, contentDescription =null )
                                                    Spacer(Modifier.padding(horizontal = 4.dp))
                                                    Text(text=user.correo!!)
                                                }
                                                Spacer(Modifier.padding(vertical = 4.dp))
                                                Row {
                                                    Icon(imageVector = Icons.Filled.Phone, contentDescription =null )
                                                    Spacer(Modifier.padding(horizontal = 4.dp))
                                                    Text(text=user.numero.toString())
                                                }
                                            }
                                            Icon(imageVector = Icons.Filled.Phone, contentDescription = null,tint= mainBrown)
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }else{
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.petlist), contentDescription = null,modifier=Modifier.size(20.dp))
                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                        Text("Lista de mascotas de interés")
                    }

                }
                if(myPets.value.isEmpty()){
                    item{
                        Card(
                            modifier= Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 20.dp),
                            colors=CardDefaults.cardColors(
                                containerColor = tertiaryGray,
                                contentColor = Color.DarkGray
                            )
                        ) {
                            Row(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 10.dp, vertical = 20.dp)) {
                                Icon(imageVector = Icons.Filled.Info, contentDescription = null)
                                Spacer(Modifier.padding(horizontal = 5.dp))
                                Text(text="No tiene mascotas de interés aún")
                            }
                        }
                    }
                }else{
                    myPets.value.forEach {adopcion->
                        item {
                            Card(modifier= Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 20.dp),
                                colors=CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = mainBrown
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ){
                                Row(
                                    modifier= Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Row {
                                        Image(painter = painterResource(id = adopcion.imagen!!), contentDescription = null, contentScale = ContentScale.Crop,modifier= Modifier
                                            .size(100.dp)
                                            .clip(
                                                RoundedCornerShape(20.dp)
                                            ))
                                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                                        Column{
                                            Text(text=adopcion.nombre!!, fontWeight = FontWeight.Bold,modifier=Modifier.padding(bottom=10.dp))
                                            Row {
                                                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null )
                                                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                                                Text(text = adopcion.autor?.nombre!!)
                                            }
                                            Spacer(Modifier.padding(vertical = 5.dp))
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Image(painter = painterResource(id = R.drawable.gmaps), contentDescription = null,modifier= Modifier.size(20.dp))
                                                Spacer(modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp))
                                                Text("A ${adopcion.distancia} km", fontWeight = FontWeight.Bold)
                                                Spacer(modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp))
                                                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription =null)
                                            }
                                        }
                                    }
                                    Icon(imageVector = Icons.Filled.Phone, contentDescription = null,tint= mainBrown)
                                }
                            }
                        }
                    }
                }
            }
            }
        Button(
            colors= ButtonDefaults.buttonColors(
                containerColor = mainAmber,
                contentColor = mainBrown
            ),
            modifier= Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 10.dp),
            onClick = { navController.navigate("add") },
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 3.dp
            )
        ) {
            Row(
                modifier=Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Agregar", fontWeight = FontWeight.Bold)
                Spacer(Modifier.padding(horizontal = 4.dp))
                Icon(imageVector = Icons.Filled.Add, contentDescription = null )
            }

        }
    }

}