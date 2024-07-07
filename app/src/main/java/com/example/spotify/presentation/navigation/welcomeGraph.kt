package com.example.spotify.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.spotify.presentation.AuthScreen
import com.example.spotify.presentation.ChooseThemeScreen
import com.example.spotify.presentation.FirstScreen
import com.example.spotify.presentation.HomeScreen
import com.example.spotify.presentation.RegisterScreen
import com.example.spotify.presentation.SignInScreen

sealed class WelcomeRoutes(val route: String) {
    object FirstScreen : WelcomeRoutes("first_screen")
    object ChooseThemeScreen : WelcomeRoutes("choose_theme_screen")
    object AuthScreen : WelcomeRoutes("auth_screen")
    object SignInScreen : WelcomeRoutes("sign_in_screen")
    object RegisterScreen : WelcomeRoutes("register_screen")
    object HomeScreen : WelcomeRoutes("home_screen")
}

@Composable
fun NavGraphWelcome() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = WelcomeRoutes.FirstScreen.route) {

        composable(WelcomeRoutes.FirstScreen.route) {
            FirstScreen(navController = navController)
        }

        composable(WelcomeRoutes.ChooseThemeScreen.route) {
            ChooseThemeScreen(navController = navController)
        }

        composable(WelcomeRoutes.AuthScreen.route) {
            AuthScreen(navController = navController)
        }

        composable(WelcomeRoutes.SignInScreen.route) {
            SignInScreen(navController = navController)
        }

        composable(WelcomeRoutes.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }

        composable(WelcomeRoutes.HomeScreen.route) {
            HomeScreen()
        }

    }
}