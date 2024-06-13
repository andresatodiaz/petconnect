package com.example.petify.ui.Presentation.Adopcion

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.petify.ui.Presentation.Login.User
import kotlinx.coroutines.flow.StateFlow


data class AdopcionItem (
    val nombre:String?=null,
    val descripcion:String?=null,
    val distancia: Double?=null,
    val edad: Int?=null,
    val imagen: Int?=null,
    val autor:User?=null,
    val interesados : SnapshotStateList<User>?= mutableStateListOf<User>()
)