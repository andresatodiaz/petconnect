package com.example.petify.ui.Presentation.Adopcion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Presentation.Emergencias.EmergenciaItem
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.mainRed
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdopcionNuevo(
    vm:AdopcionVM,
    user:User,
    navController:NavController
){
    val titulo= remember{ mutableStateOf("") }
    val descripcion= remember{ mutableStateOf("") }
    val direccion= remember{ mutableStateOf("") }
    val horario = remember{ mutableStateOf("") }
    val focusManager= LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            focusManager.clearFocus()
        },
        contentAlignment = Alignment.TopCenter
    ){
        LazyColumn(
            modifier= Modifier
                .fillMaxWidth(0.9f),
            contentPadding = PaddingValues(bottom=100.dp)
        ){
            item{
                Row(modifier= Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.emergencias), contentDescription =null,modifier= Modifier.size(30.dp) )
                    Spacer(modifier= Modifier.padding(horizontal = 4.dp))
                    Text(text="Agregar servicio")
                }
            }
            item{
                Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = null,modifier= Modifier.fillMaxWidth(0.1f))
                    OutlinedTextField(
                        colors= TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = mainBrown
                        ),
                        placeholder ={ Text(text = "Ingresa el nombre...") },
                        shape= CircleShape,
                        label={
                            Text("nombre",color= mainBrown)
                        },
                        value = titulo.value, onValueChange = {
                            titulo.value=it
                        },
                        modifier= Modifier
                            .fillMaxWidth(0.9f)
                            .padding(vertical = 10.dp)
                    )
                }
            }
            item{
                Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = null,modifier= Modifier.fillMaxWidth(0.1f))
                    OutlinedTextField(
                        colors= TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = mainBrown
                        ),
                        placeholder ={ Text(text = "Ingresa la edad...") },
                        shape= CircleShape,
                        label={
                            Text("Edad",color= mainBrown)
                        },
                        value = horario.value, onValueChange = {
                            horario.value=it
                        },
                        modifier= Modifier
                            .fillMaxWidth(0.9f)
                            .padding(vertical = 10.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number)
                    )
                }
            }
            item{
                OutlinedTextField(
                    colors= TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = mainBrown
                    ),
                    placeholder ={ Text(text = "Ingresa tu descripción...") },
                    shape= RoundedCornerShape(20.dp),
                    label={
                        Text("Descripción",color= mainBrown)
                    },
                    value = descripcion.value, onValueChange = {
                        descripcion.value=it
                    },
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(vertical = 10.dp)
                )
            }

            item{
                Spacer(Modifier.padding(vertical = 5.dp))
                Column(modifier= Modifier.fillMaxWidth()){
                    Row(modifier= Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Icon(imageVector = Icons.Filled.Create, contentDescription = null,tint= mainRed,modifier= Modifier.fillMaxWidth(0.1f))
                        Text(text = "Foto de la mascota" )
                    }
                    Spacer(Modifier.padding(vertical = 5.dp))
                    Image(painter = painterResource(id = R.drawable.adopcionnew) , contentDescription =null,modifier= Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(
                            RoundedCornerShape(20.dp)
                        ),
                        contentScale = ContentScale.Crop
                    )
                }


            }
            item{
                Row(
                    modifier= Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        modifier= Modifier.padding(10.dp),
                        colors= ButtonDefaults.buttonColors(
                            contentColor = mainBrown,
                            containerColor = mainAmber
                        ),
                        onClick = {
                            vm.addPets(
                                AdopcionItem(
                                    nombre =titulo.value,
                                    descripcion = descripcion.value,
                                    autor=user,
                                    imagen = R.drawable.adopcionnew,
                                    distancia = String.format("%.1f", Random.nextDouble(1.1, 5.2)).toDouble(),
                                    edad= if(horario.value!="") horario.value.toInt() else 0
                                ),
                                navController
                            )
                        },
                        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 1.dp
                        )
                    ) {
                        Text(text = "Crear", fontWeight = FontWeight.Bold)
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
                    }
                }
            }
        }
    }
}