package com.example.petify.ui.Presentation.Adopcion

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.SwipeableCardState
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.example.petify.R
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.mainGreen
import com.example.petify.ui.theme.mainRed
import com.example.petify.ui.theme.secondaryAmber
import com.example.petify.ui.theme.tertiaryGray
import com.example.petify.ui.theme.tertiaryPink
import kotlinx.coroutines.launch

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun AdopcionScreen(
    vm: AdopcionVM,
    navController: NavController,
    user: User
) {
    val listPets= vm.showablePets(user)
    val states = listPets.reversed()
        .map { it to rememberSwipeableCardState() }
    val scope = rememberCoroutineScope()
    Column {
        Box(
            modifier= Modifier.fillMaxSize()
        ){
            emptyCard(
                Modifier
                    .fillMaxHeight(0.95f)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.TopCenter))
            states.forEach {(pet,state)->
                if(state.swipedDirection==null){
                    LaunchedEffect(key1 = state.offset.value.x){
                        Log.i("offset",state.offset.value.x.toString())
                    }
                    val color= animateColorAsState(targetValue = if (state.offset.value.x>200) mainGreen else if (state.offset.value.x<-200) mainRed else Color.Transparent,
                        label = "color",
                        animationSpec = tween(
                            durationMillis = 200, // 1 second transition
                            easing = LinearEasing // or choose other easing functions
                        )
                    )
                    petCard(modifier = Modifier
                        .fillMaxHeight(0.95f)
                        .fillMaxWidth(0.9f)
                        .align(Alignment.TopCenter)
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(Direction.Down,Direction.Up),
                            onSwiped = {direction ->
                                // swipes are handled by the LaunchedEffect
                                // so that we track button clicks & swipes
                                // from the same place
                                if(direction==Direction.Right){
                                    vm.agregarInteresado(
                                        pet,
                                        user
                                    )
                                }
                            },
                            onSwipeCancel = {
                                Log.d("Swipeable-Card", "Cancelled swipe")
                            }
                        ),
                        pet = pet,
                        color=color.value
                        )
                }


            }
            Row(modifier= Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth(0.9f)
                .align(Alignment.BottomCenter)
                .padding(bottom=15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
                ){
                IconButton(
                    modifier=Modifier
                        .background(mainBrown, CircleShape),
                    onClick = { scope.launch {
                        val last = states.reversed()
                            .firstOrNull {
                                it.second.offset.value == Offset(0f, 0f)
                            }?.second
                        last?.swipe(Direction.Left)
                    } }
                ) {
                    Icon(imageVector = Icons.Filled.Clear, contentDescription = null,tint=Color.White)
                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                IconButton(
                    modifier=Modifier
                        .background(mainAmber, CircleShape),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                IconButton(
                    modifier=Modifier
                        .background(mainBrown, CircleShape),
                    onClick = {
                        scope.launch {
                            val last = states.reversed()
                                .firstOrNull {
                                    it.second.offset.value == Offset(0f, 0f)
                                }?.second
                            last?.swipe(Direction.Right)
                        }
                        states.reversed().firstOrNull()?.let {
                            vm.agregarInteresado(
                                it.first,
                                user
                            )
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = null,tint=Color.White)
                }
            }
            Row(
                modifier= Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.1f)
                    .align(Alignment.BottomCenter)
                    .padding(bottom=15.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    modifier=Modifier
                        .background(mainBrown, CircleShape),
                    onClick = {
                        navController.navigate("list")
                    }
                ) {
                    Icon(painter = painterResource(id = R.drawable.petlist), contentDescription = null,tint=Color.White)
                }
            }


        }
    }

}
@Composable
fun emptyCard(
    modifier:Modifier
){
    Card(
        modifier = modifier
    ) {
        Box(modifier= Modifier
            .fillMaxSize()
            .background(tertiaryGray),
            contentAlignment = Alignment.Center
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally){
                Icon(painter= painterResource(id = R.drawable.peticon),contentDescription = null,tint=Color.DarkGray)
                Spacer(Modifier.padding(20.dp))
                Text("No hay más mascotas...",color= Color.DarkGray, fontSize = 25.sp)
            }
        }
    }
}



@Composable
fun petCard(modifier:Modifier,
            pet:AdopcionItem,
            color:Color
){
    val brush = Brush.verticalGradient(listOf(Color.Transparent,secondaryAmber), startY = 0.4f)
    Card(
        modifier
    ) {
        Box(modifier=Modifier.fillMaxSize()){
            Image(
                painter= painterResource(id = pet.imagen!!),
                contentDescription="pet",
                modifier=Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(brush))
            Box(modifier= Modifier
                .fillMaxSize()
                .background(color.copy(alpha = color.alpha * 0.5f)))
            Column(modifier= Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
                ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment=Alignment.CenterVertically,
                    modifier=Modifier.fillMaxWidth()){
                    Row {
                        Text(pet.nombre!!, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                        Text("| "+pet.edad+ "años", fontSize = 15.sp)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Icon(imageVector = Icons.Filled.LocationOn, contentDescription ="location",tint= mainRed )
                        Text(text = pet.distancia.toString()+" km", fontSize = 15.sp)
                    }
                }
                Spacer(Modifier.padding(vertical = 5.dp))
                Text(text = pet.descripcion!!,modifier=Modifier.fillMaxWidth(), fontSize = 18.sp)
            }
        }
    }
}
