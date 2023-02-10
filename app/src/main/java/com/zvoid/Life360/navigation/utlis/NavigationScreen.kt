package com.zvoid.Life360.navigation.utlis

sealed class NavigationScreen(val route: String) {
    object SplashScreen : NavigationScreen("splash_screen")
    object IntroScreen : NavigationScreen("intro_screen ")
}