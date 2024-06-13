package com.example.petify.ui.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.petify.R
import com.example.petify.ui.theme.tertiaryGray

@Composable
fun LocationItem(
    distance:Double
) {
    Row(
        modifier= Modifier.background(tertiaryGray, CircleShape),
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.padding(start=10.dp))
        Image(painter = painterResource(id = R.drawable.gmaps), contentDescription = null,modifier= Modifier.size(30.dp))
        Spacer(modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp))
        Text("A ${distance} km", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp))
        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription =null)
        Spacer(modifier = Modifier.padding(end=10.dp))
    }
}