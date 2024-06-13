package com.example.petify.ui.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.petify.R
import com.example.petify.ui.theme.secondaryAmber

@Composable
fun Socials(

){
    Row(
        modifier=Modifier
            .padding(vertical = 10.dp)
    ){
        Row(Modifier
            .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.phone), contentDescription = null,modifier=Modifier
                .size(30.dp))
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.ig), contentDescription = null,modifier=Modifier
                .size(30.dp))
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.wa), contentDescription = null,modifier=Modifier
                .size(30.dp))
            Spacer(modifier = Modifier.padding(5.dp))


        }
    }
}