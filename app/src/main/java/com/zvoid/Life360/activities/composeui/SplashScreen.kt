package com.zvoid.Life360.activities.composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zvoid.Life360.R
import com.zvoid.Life360.navigation.utlis.NavigationScreen
import com.zvoid.Life360.ui.theme.Life360Theme
import com.zvoid.Life360.ui.theme.SplashScreenBG
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {


    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false


    Box(
        modifier = Modifier
            .background(SplashScreenBG)
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //logo
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(92.dp),
                tint = Color.White
            )


        }
    }


    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(NavigationScreen.IntroScreen.route)
    }
}



