package com.zvoid.Life360.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zvoid.Life360.activities.composeui.IntroScreen
import com.zvoid.Life360.activities.composeui.SplashScreen

import com.zvoid.Life360.navigation.utlis.NavigationScreen


@Composable
fun StartNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationScreen.SplashScreen.route) {
        composable(NavigationScreen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(NavigationScreen.IntroScreen.route) {
            IntroScreen()
        }
    }

}