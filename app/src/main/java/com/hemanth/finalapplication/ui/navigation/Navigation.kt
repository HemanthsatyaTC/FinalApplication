package com.hemanth.finalapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hemanth.finalapplication.ui.screens.HomeScreen
import com.hemanth.finalapplication.ui.screens.login.LoginScreen
import com.hemanth.finalapplication.ui.screens.login.SignInScreen

enum class Navigation {
    LOGIN, SIGN_IN, HOME
}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Navigation.LOGIN.name){
        composable(Navigation.LOGIN.name){
            LoginScreen(navController)
        }
        composable(Navigation.SIGN_IN.name) {
            SignInScreen(navController)
        }
        composable(Navigation.HOME.name) {
            HomeScreen()
        }


    }

}