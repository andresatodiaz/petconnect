package com.example.petify.ui.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petify.R
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.secondaryBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title:String?="",
    user:User,
    action:()->Unit,

) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text= buildAnnotatedString {
                    withStyle(style= SpanStyle(fontWeight = FontWeight.Bold)){
                        append("Pet")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)){
                        append("Connect")
                    }
                },color= mainBrown, fontWeight = FontWeight.Bold, fontSize = 15.sp,modifier=Modifier.padding(start=10.dp))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                if (user.pro?.value==true){
                    Row(
                        modifier=Modifier.background(mainAmber, CircleShape)
                    ){
                        Text(text = "Pro",modifier=Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
                    }
                }
            }
             },
        navigationIcon = {
            Image(painter = painterResource(id = R.drawable.petify), contentDescription = "icon",modifier= Modifier
                .size(50.dp)
                .padding(start = 10.dp))
        },
        actions = {
            Row(
                modifier=Modifier.padding(end=20.dp)
            ){
                Icon(imageVector = Icons.Filled.Face, contentDescription = "user",modifier= Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .clickable {
                        action()
                    },tint= mainBrown)
            }

        }
    )
}