package com.example.petify.ui.Presentation.Servicios

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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Components.DetailLayout
import com.example.petify.ui.Components.LocationItem
import com.example.petify.ui.Components.Socials
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.secondaryAmber
import com.example.petify.ui.theme.secondaryBrown
import com.example.petify.ui.theme.tertiaryGray

@Composable
fun ServiciosDetail(
    servicioItem: ServicioItem
){
    DetailLayout(
        banner = servicioItem.banner!!,
        titulo = servicioItem.titulo!!,
        descripcion = servicioItem.descripcion!!,
        distance = servicioItem.distance!!,
        autor = servicioItem.autor!!
    )
}