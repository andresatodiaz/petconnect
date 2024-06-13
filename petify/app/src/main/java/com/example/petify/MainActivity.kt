package com.example.petify

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petify.ui.Navigation.NavigationScreen
import com.example.petify.ui.theme.PetifyTheme
import com.example.petify.ui.theme.mainAmber
import com.example.petify.ui.theme.secondaryAmber
import com.example.petify.ui.theme.tertiaryGray
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val systemUiController= rememberSystemUiController()
                    systemUiController.setSystemBarsColor(tertiaryGray)
                    systemUiController.setNavigationBarColor(secondaryAmber)
                    NavigationScreen()
                }
            }
        }
    }
    override fun getResources(): Resources {
        val resources = super.getResources()
        resources.updateConfiguration(
            Configuration(resources.configuration).apply {
                fontScale = 1.0f
            },
            resources.displayMetrics
        )
        return resources
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetifyTheme {
        Greeting("Android")
    }
}