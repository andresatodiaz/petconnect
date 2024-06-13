package com.example.petify.ui.Presentation.Adopcion

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Presentation.Login.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AdopcionVM @Inject constructor():ViewModel() {
    val listPets = mutableStateListOf<AdopcionItem>(
        AdopcionItem(
            nombre = "Chicha",
            descripcion = "Chicha es un perro encontrado hace 2 meses y necesita un hogar!",
            distancia = 4.1,
            imagen = R.drawable.adopcion1,
            edad = 1,
            autor = User(
                nombre="Andres Sato",
                edad=24,
                correo = "andres.satodiaz@gmail.com",
                contrasena="sato1",
                numero=936779244
            )
        ),
        AdopcionItem(
            nombre = "Yuyu",
            descripcion = "Yuyu es un perro encontrado hace 5 meses y necesita un hogar!",
            distancia = 5.5,
            imagen = R.drawable.adopcion2,
            edad= 2,
            autor = User(
                nombre="Andres Sato",
                edad=24,
                correo = "andres.satodiaz@gmail.com",
                contrasena="sato1",
                numero=936779244
            )
        ),
        AdopcionItem(
            nombre = "Enanu",
            descripcion = "Enanu es un perro encontrado hace 2 meses y necesita un hogar!",
            distancia = 3.2,
            imagen = R.drawable.adopcion3,
            edad = 1,
            autor = User(
                nombre="Andres Sato",
                edad=24,
                correo = "andres.satodiaz@gmail.com",
                contrasena="sato1",
                numero=936779244
            )
        ),
        AdopcionItem(
            nombre = "Toby",
            descripcion = "Toby es un perro encontrado hace 2 meses y necesita un hogar!",
            distancia = 5.0,
            imagen = R.drawable.adopcion4,
            edad = 4,
            autor = User(
                nombre="Andres Sato",
                edad=24,
                correo = "andres.satodiaz@gmail.com",
                contrasena="sato1",
                numero=936779244
            )
        ),

        )

    fun agregarInteresado(adopcionItem: AdopcionItem,user: User){
        if(adopcionItem.interesados?.contains(user) == false && adopcionItem.autor?.nombre != user.nombre){
            adopcionItem.interesados.add(
                user
            )
        }
    }

    fun myPets(user: User):List<AdopcionItem>{
        val tempList = mutableListOf<AdopcionItem>()
        listPets.forEach {adopcionItem ->
            Log.i("int",adopcionItem.interesados?.toList().toString())
            Log.i("int2",user.toString())
            if(adopcionItem.interesados!=null){
                adopcionItem.interesados.forEach { userItem->
                    if(userItem.correo==user.correo){
                        tempList.add(adopcionItem)
                    }
                }
            }
        }
        return tempList
    }

    fun showablePets(user:User):List<AdopcionItem>{
        val tempList = mutableListOf<AdopcionItem>()
        listPets.forEach {adopcionItem ->
            if( (adopcionItem.interesados==null || (adopcionItem.interesados.find {userItem->
                userItem.correo==user.correo
                } == null)) && adopcionItem.autor?.correo!=user.correo ){
               tempList.add(adopcionItem)
            }
        }
        return tempList
    }

    fun addPets(adopcionItem: AdopcionItem, navController: NavController){
        if(!listPets.contains(adopcionItem)){
            listPets.add(0,adopcionItem)
            navController.navigate("home")
        }
    }

    fun showRequest(user: User):List<AdopcionItem>{
        val solicitudes= listPets.filter { adopcion->
            adopcion.autor?.nombre==user.nombre
        }
        return solicitudes
    }
}