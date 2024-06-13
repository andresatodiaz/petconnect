package com.example.petify.ui.Presentation.Profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Presentation.Login.LoginVM
import com.example.petify.ui.Presentation.Login.User
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.secondaryAmber

@Composable
fun ProfileProSub(
    navController: NavController,
    vm: LoginVM,
    user:User
){
    val lightGoldStart = Color(0xFFFFFDE4)    // Light gold (similar to ivory)
    val lightGoldMid = Color(0xFFFFEBCD)      // Slightly more saturated light gold (like blanched almond)
    val lightGoldEnd = Color(0xFFFAFAD2)
    val goldGradient = Brush.verticalGradient(
        colors = listOf(lightGoldStart, lightGoldMid, lightGoldEnd), // You can add/remove colors as desired
    )
    Box(
        Modifier.fillMaxSize()
    ){
        Card(
            shape= RoundedCornerShape(20.dp),
            modifier= Modifier
                .fillMaxSize(0.9f)
                .align(Alignment.Center),
            border = BorderStroke(2.dp, mainAmber),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 5.dp
            )
        ){
            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .background(goldGradient, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ){
                LazyColumn(modifier= Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight()
                    .padding(top = 20.dp)) {
                    item{
                        Image(painter = painterResource(id = R.drawable.petify), contentDescription = null,modifier=Modifier.size(40.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text= buildAnnotatedString {
                                withStyle(style= SpanStyle(fontWeight = FontWeight.Bold)){
                                    append("Pet")
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)){
                                    append("Connect")
                                }
                            })
                            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                            Row(
                                modifier=Modifier.background(mainAmber, CircleShape)
                            ){
                                Text(text = "Pro",modifier=Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
                            }
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = "¡Descubre PetConnect Pro, la app que revoluciona el cuidado de tus mascotas en Lima! \uD83D\uDC3E\uD83D\uDCF1 Con PetConnect Pro, tendrás acceso a un mundo de servicios y herramientas que te facilitarán la vida como dueño responsable. \uD83D\uDC36\uD83D\uDC31\n" +
                                "\n" +
                                "Servicios para tus peludos amigos:\n" +
                                "\n" +
                                "Directorio de servicios: Encuentra fácilmente paseadores de confianza \uD83E\uDDAE, cuidadores de mascotas \uD83C\uDFE1, entrenadores \uD83C\uDFBE y mucho más. ¡Todo en un solo lugar!\n" +
                                "Veterinarios de emergencia: ¿Tu mascota necesita atención urgente? \uD83D\uDEA8 ¡No te preocupes! Encuentra veterinarios disponibles las 24 horas del día, los 7 días de la semana. \uD83D\uDE91\n" +
                                "Mascotas en adopción: ¡Dale un hogar lleno de amor a un nuevo amigo! \uD83D\uDC3E❤️ Explora nuestra sección de adopciones y encuentra al compañero perfecto para ti.\n" +
                                "Alertas de mascotas perdidas: ¿Perdiste a tu mascota? \uD83D\uDC94 ¡No pierdas la esperanza! Publica una alerta con foto y descripción, y recibe notificaciones si alguien la encuentra.")

                    }
                }
                Button(
                    modifier= Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 20.dp, end = 20.dp),
                    colors= ButtonDefaults.buttonColors(
                        contentColor = mainBrown,
                        containerColor = mainAmber
                    ),
                    onClick = {
                        vm.turnPro(user,navController)
                    },
                    contentPadding = PaddingValues(20.dp)
                ){
                    if(user.pro?.value==false){
                        Text("Convertirme Pro")
                    }else{
                        Text("Cancelar")
                    }
                    Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription =null )
                }
            }
        }
    }
}