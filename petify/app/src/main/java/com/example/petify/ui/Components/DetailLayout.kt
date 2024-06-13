package com.example.petify.ui.Components

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petify.ui.theme.mainRed
import com.example.petify.ui.theme.tertiaryGray
import com.example.petify.ui.theme.tertiaryPink

@Composable
fun DetailLayout(
    banner:Int,
    titulo:String,
    descripcion:String,
    distance:Double,
    autor:String,
    categoria:String?=null
) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier= Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom=100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            Box{
                val imageOffset = (-scrollState.firstVisibleItemScrollOffset * 0.1f).coerceIn(-200f, 0f)
                Image(
                    painter = painterResource(id = banner),
                    contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .graphicsLayer { // Apply parallax effect with graphicsLayer
                            translationY = imageOffset
                        },
                    contentScale = ContentScale.Crop
                )
                if(categoria!=null){
                    Card(
                        modifier= Modifier
                            .align(Alignment.TopStart)
                            .padding(start = 20.dp, top = 20.dp),
                        shape= CircleShape,
                        colors = CardDefaults.cardColors(
                            containerColor = mainRed,
                            contentColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ){
                        Row(Modifier
                            .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center){
                            Icon(imageVector = Icons.Filled.Info, contentDescription = null,tint=Color.White )
                            Spacer(Modifier.padding(horizontal = 5.dp))
                            Text(text= "$categoria", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

        }
        item{
            Text(text=titulo, fontWeight = FontWeight.Bold, fontSize = 20.sp,modifier= Modifier.padding(top=20.dp, bottom = 10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier= Modifier.padding(bottom=20.dp)
            ) {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "account")
                Spacer(Modifier.padding(horizontal = 5.dp))
                Text(text=autor)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier= Modifier.fillMaxWidth(0.9f)
            ) {
                LocationItem(distance = distance)
                Socials()
            }

            Column(modifier= Modifier
                .fillMaxWidth(0.9f)
                .background(tertiaryGray, RoundedCornerShape(20.dp))) {
                Text(text=descripcion,modifier= Modifier
                    .fillMaxWidth()
                    .padding(20.dp), textAlign = TextAlign.Justify)
            }
        }
    }
}