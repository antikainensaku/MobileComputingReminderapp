package com.example.loginscreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loginscreen.ui.home.Home
import com.example.loginscreen.ui.home.Profile
import com.example.loginscreen.ui.login.Login
import com.example.loginscreen.ui.login.Register
import com.example.loginscreen.ui.welcome.Welcome

@Composable
fun ReminderApp(
    appState: ReminderAppState = rememberReminderAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = "welcome"
    ) {
        composable(route = "welcome") {
            Welcome(navController = appState.navController)
        }
        composable(route = "login") {
            Login(navController = appState.navController)
        }
        composable(route = "register") {
            Register(navController = appState.navController)
        }
        composable(route = "home") {
            Home(navController = appState.navController)
        }
        composable(route = "profile") {
            Profile(navController = appState.navController)
        }
    }
}