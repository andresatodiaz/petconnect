package com.example.petify.ui.Components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.mainBrown
import com.example.petify.ui.theme.secondaryAmber
import com.example.petify.ui.theme.secondaryBrown

@Composable
fun BottomBar(
    navController:NavController,
) {
    val selection= remember{ mutableStateOf("servicios") }
    BottomAppBar(
        modifier=Modifier.fillMaxWidth(),
        containerColor = mainAmber
    ) {
        navItems.forEach { screen->
            NavigationBarItem(
                modifier= Modifier.weight(1f),
                selected = selection.value==screen.route,
                onClick = {
                    navController.navigate(screen.route)
                    selection.value=screen.route
                },
                icon = {
                    Icon(painter = painterResource(id = screen.icon), contentDescription = "Icon",tint=if(selection.value==screen.route) secondaryBrown else mainBrown,
                        modifier=Modifier.size(25.dp))
                },
                label = {
                    Text(text = screen.title, fontWeight =if(selection.value==screen.route) FontWeight.Bold else FontWeight.Normal, fontSize = 12.sp)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = secondaryAmber
                )
            )
        }
    }

}

val navItems = listOf<NavItem>(
    NavItem(
        title = "Servicios",
        icon= R.drawable.servicios,
        route = "servicios"
    ),
    NavItem(
        title = "Adopción",
        icon=R.drawable.adopcion,
        route = "adopcion"
    ),
    NavItem(
        title = "Emergencias",
        icon=R.drawable.emergencias,
        route = "Emergencias"
    ),
    NavItem(
        title = "Alertas",
        icon=R.drawable.alertas,
        route="alertas"
    )
)
