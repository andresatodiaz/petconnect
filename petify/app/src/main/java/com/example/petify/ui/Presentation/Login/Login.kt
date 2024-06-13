package com.example.petify.ui.Presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.secondaryAmber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginHome(
    vm:LoginVM,
    navControllerGlobal: NavController,
    navController: NavController,
    login:MutableState<Boolean>
){
    val correo = remember{ mutableStateOf("") }
    val contrasena = remember{ mutableStateOf("") }
    val visibleContrasena = remember{ mutableStateOf(false) }
    val focusManager= LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    LaunchedEffect(key1 = true ){
        login.value=true
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(mainAmber)
        .clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            focusManager.clearFocus()
        }
    ){
        Card(
            shape= RoundedCornerShape(20.dp),
            colors=CardDefaults.cardColors(
                containerColor = secondaryAmber,
                contentColor = mainBrown
            ),
            modifier= Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.Center)
        ) {
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(Modifier.padding(5.dp))
                Image(painter = painterResource(id = R.drawable.petify), contentDescription =null,modifier=Modifier.size(80.dp))
                Spacer(Modifier.padding(5.dp))
                Text(text=buildAnnotatedString {
                    withStyle(style= SpanStyle(fontWeight = FontWeight.Bold)){
                        append("Pet")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)){
                        append("Connect")
                    }
                })
                Spacer(Modifier.padding(10.dp))
                OutlinedTextField(
                    colors=TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = mainBrown
                    ),
                    placeholder ={ Text(text = "Ingresa tu correo...")},
                    shape= CircleShape,
                    label={
                          Text("Correo",color= mainBrown)
                    },
                    value = correo.value, onValueChange = {
                    correo.value=it
                } )
                Spacer(Modifier.padding(10.dp))
                OutlinedTextField(
                    colors=TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = mainBrown
                    ),
                    placeholder ={ Text(text = "Ingresa tu contraseña...")},
                    shape= CircleShape,
                    label={
                        Text("Contraseña",color= mainBrown)
                    },
                    value = contrasena.value, onValueChange = {
                    contrasena.value=it
                    },
                    visualTransformation = if(visibleContrasena.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Icon(painterResource(id =  if(!visibleContrasena.value) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24), contentDescription = null,tint= mainBrown,modifier=Modifier.clickable {
                            visibleContrasena.value=!visibleContrasena.value
                        })
                    }
                )
                Spacer(Modifier.padding(10.dp))
                Button(
                    modifier=Modifier.padding(10.dp),
                    colors=ButtonDefaults.buttonColors(
                        contentColor = mainBrown,
                        containerColor = mainAmber
                    ),
                    onClick = {
                        vm.login(correo.value,contrasena.value,navController=navControllerGlobal,login=login)
                    },
                    contentPadding = PaddingValues(20.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 1.dp
                    )
                ) {

                    Text(text = "Iniciar sesión", fontWeight = FontWeight.Bold)
                    Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
                }
                Spacer(Modifier.padding(5.dp))
                TextButton(onClick = {
                    navController.navigate("register")
                }) {
                    Text(text= buildAnnotatedString {
                        withStyle(style= SpanStyle(fontWeight = FontWeight.Normal)){
                            append("No tienes una cuenta, ")
                        }
                        withStyle(style= SpanStyle(fontWeight = FontWeight.Bold)){
                            append("Regístrate!")
                        }
                    },color= mainBrown)
                }
            }
        }
    }
}