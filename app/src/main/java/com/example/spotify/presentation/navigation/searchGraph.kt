package com.example.spotify.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotify.data.phonkList
import com.example.spotify.data.songsList
import com.example.spotify.presentation.AuthScreen
import com.example.spotify.presentation.ChooseThemeScreen
import com.example.spotify.presentation.FirstScreen
import com.example.spotify.presentation.SignInScreen
import com.example.spotify.presentation.news.ComedyScreen
import com.example.spotify.presentation.news.NewsScreen
import com.example.spotify.presentation.news.PhonkScreen
import com.example.spotify.presentation.news.PodcastsScreen
import com.example.spotify.presentation.news.RapScreen

sealed class SearchRoutes(val route: String) {
    object NewsScreen : SearchRoutes("news_screen")
    object PhonkScreen : SearchRoutes("phonk_screen")
    object ComedyScreen : SearchRoutes("comedy_screen")
    object PodcastsScreen : SearchRoutes("podcasts_screen")
    object RapScreen : SearchRoutes("rap_screen")

}

@Composable
fun NavGraphSearch() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SearchRoutes.NewsScreen.route) {

        composable(SearchRoutes.NewsScreen.route) {
            NewsScreen(navController = navController)
        }

        composable(SearchRoutes.PhonkScreen.route) {
            PhonkScreen(navController = navController,
                phonkList)
        }

        composable(SearchRoutes.ComedyScreen.route) {
            ComedyScreen(navController = navController)
        }

        composable(SearchRoutes.PodcastsScreen.route) {
            PodcastsScreen(navController = navController)
        }

        composable(SearchRoutes.RapScreen.route) {
            RapScreen(navController = navController)
        }

    }
}