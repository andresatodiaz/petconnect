package com.example.petify.ui.Presentation.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class User (
    val nombre: String?=null,
    val edad: Int?=null,
    val correo: String?=null,
    val contrasena: String?=null,
    val numero: Int?=null,
    val pro:MutableState<Boolean> = mutableStateOf(false)
)