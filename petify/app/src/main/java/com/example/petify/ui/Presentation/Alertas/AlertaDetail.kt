package com.example.petify.ui.Presentation.Alertas

import androidx.compose.runtime.Composable
import com.example.petify.ui.Components.DetailLayout

@Composable
fun AlertaDetail(
    alertaItem: AlertaItem
){
    DetailLayout(
        banner = alertaItem.banner!!,
        titulo = alertaItem.titulo!!,
        descripcion = alertaItem.descripcion!!,
        distance = alertaItem.distance!!,
        autor = alertaItem.autor!!,
        categoria = alertaItem.categoria!!
    )
}