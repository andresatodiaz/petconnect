package com.example.petify.ui.Presentation.Emergencias

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petify.ui.Components.DetailLayout
import com.example.petify.ui.Components.LocationItem
import com.example.petify.ui.Components.Socials
import com.example.petify.ui.theme.tertiaryGray

@Composable
fun EmergenciaDetail(
    emergenciaItem:EmergenciaItem
){
    DetailLayout(
        banner = emergenciaItem.banner!!,
        titulo = emergenciaItem.titulo!!,
        descripcion = emergenciaItem.descripcion!!,
        distance = emergenciaItem.distance!!,
        autor = emergenciaItem.autor!!,
        categoria = emergenciaItem.horario
    )
}