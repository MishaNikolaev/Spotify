package com.example.spotify.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spotify.R
import com.example.spotify.data.songsList
import com.example.spotify.presentation.AuthScreen
import com.example.spotify.presentation.ChooseThemeScreen
import com.example.spotify.presentation.FirstScreen
import com.example.spotify.presentation.HomeScreen
import com.example.spotify.presentation.RegisterScreen
import com.example.spotify.presentation.SignInScreen
import com.example.spotify.presentation.home.HomeScreenUI
import com.example.spotify.presentation.news.NewsScreen
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiGreen

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
            HomeScreen(songsList)
        }

        composable(WelcomeRoutes.HomeScreen.route) {
            MainScreen()
        }

    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavigationGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News,
        BottomNavItem.Favorite
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavItem("Home", R.drawable.home_2, "home")
    object News : BottomNavItem("News", R.drawable.discovery_1, "news")
    object Favorite : BottomNavItem("Favorite", R.drawable.profile_1, "favorite")
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route, modifier = modifier) {
        composable(BottomNavItem.Home.route) {
            HomeScreenUI() // Ваш экран HomeScreen
        }
        composable(BottomNavItem.News.route) {
            NewsScreen() // Ваш экран NewsScreen
        }
        composable(BottomNavItem.Favorite.route) {
            HomeScreen(songsList) // Ваш экран FavoriteScreen
        }
    }
}