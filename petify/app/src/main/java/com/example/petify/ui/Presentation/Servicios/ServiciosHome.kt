package com.example.petify.ui.Presentation.Servicios

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.mainRed
import com.example.petify.ui.theme.tertiaryGray
import com.example.petify.ui.theme.tertiaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiciosHome(
    vm: ServiciosVM,
    navController: NavController,
    user: User
){
    val text= remember{ mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    val serviciosItems= remember{ mutableStateOf(vm.serviciosItems.toList())}

    LaunchedEffect(key1 = text.value ){
        if(text.value!=""){
            serviciosItems.value = vm.serviciosItems.filter { servicio->
                servicio.titulo!!.lowercase().contains(text.value.lowercase())
            }
        }else{
            serviciosItems.value = vm.serviciosItems
        }
    }

    Box(
        modifier= Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                focusManager.clearFocus()
            },
        contentAlignment = Alignment.TopCenter
    ){

        LazyColumn(modifier=Modifier.fillMaxWidth(0.9f),
            contentPadding = PaddingValues(bottom=100.dp)
        ){
            item{
                Card(
                    modifier= Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    shape= RoundedCornerShape(20.dp)
                ){
                    Box(modifier=Modifier.fillMaxSize()){
                       Image(painter = painterResource(id = R.drawable.serviciosbanner),modifier=Modifier.fillMaxSize(), contentDescription = "banner",
                           contentScale = ContentScale.Crop)
                        Box(modifier = Modifier
                            .fillMaxSize()
                            //.background(brush),
                            ,contentAlignment = Alignment.BottomCenter){
                            Column(
                                modifier= Modifier
                                    .padding(20.dp)
                            ){
                                Text("Servicios para mascotas", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                Text("Encuentra servicios como paseos, aseo, cuidados, spa y más!", fontSize = 15.sp)
                            }
                        }
                    }
                }
            }
            item {
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    OutlinedTextField(
                        value = text.value ,
                        onValueChange ={ text.value=it},
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
                        },
                        placeholder = {
                            Text("Buscar...")
                        },
                        shape = CircleShape,
                        colors=TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = tertiaryGray,
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = mainBrown
                        ),
                        trailingIcon = {
                            if(text.value==""){
                                Icon(imageVector = Icons.Filled.MoreVert, contentDescription ="more",tint= mainBrown)
                            }else{
                                Icon(imageVector = Icons.Filled.Clear, contentDescription ="clear",tint= mainBrown,modifier=Modifier.clickable {
                                    text.value=""
                                })
                            }

                        }
                    )
                }

            }
            itemsIndexed(serviciosItems.value){index,servicio->
                if (index!=0){
                    Spacer(Modifier.padding(10.dp))
                }
                Card(
                    modifier= Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .clickable {
                            vm.getDetail(servicio)
                            navController.navigate("detail")
                        },
                    shape= RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    )
                ){
                    Box(modifier=Modifier.fillMaxSize()){
                        Image(painter = painterResource(id = servicio.banner!!), contentDescription = "background", contentScale = ContentScale.Crop,modifier= Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f))
                        Column(modifier= Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .align(Alignment.BottomCenter)
                        ) {
                            Column(
                                modifier=Modifier.padding(20.dp)
                            ) {
                                Text(text=servicio.titulo!!, fontWeight = FontWeight.Bold,modifier=Modifier.padding(bottom=10.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment=Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ){
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null )
                                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text=servicio.autor!!)
                                    }
                                    Row(modifier=Modifier.background(tertiaryGray, CircleShape)) {
                                        Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier.padding(5.dp)) {
                                            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "location",tint= mainRed)
                                            Spacer(Modifier.padding(horizontal = 5.dp))
                                            Text(text=servicio.distance.toString()+" km ")
                                        }
                                        Spacer(Modifier.padding(horizontal = 10.dp))
                                        Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier.padding(5.dp)) {
                                            Icon(imageVector = Icons.Filled.Star, contentDescription = "location",tint= mainBrown)
                                            Spacer(Modifier.padding(horizontal = 5.dp))
                                            Text(text=servicio.stars.toString()+"/5 ")
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        if(user.pro?.value==true){
            Button(
                colors=ButtonDefaults.buttonColors(
                    containerColor = mainAmber,
                    contentColor = mainBrown
                ),
                modifier= Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 10.dp),
                onClick = {
                    navController.navigate("add") },
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
}


