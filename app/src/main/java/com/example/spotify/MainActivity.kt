package com.example.spotify

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.spotify.presentation.AuthScreen
import com.example.spotify.presentation.ChooseThemeScreen
import com.example.spotify.presentation.FirstScreen
import com.example.spotify.presentation.RegisterScreen
import com.example.spotify.presentation.SignInScreen
import com.example.spotify.presentation.SongViewModel
import com.example.spotify.presentation.navigation.MainScreen
import com.example.spotify.presentation.navigation.NavGraphSearch
import com.example.spotify.presentation.navigation.NavGraphWelcome
import com.example.spotify.ui.theme.SpotifyTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.perf.metrics.AddTrace

class MainActivity : ComponentActivity() {
    private val viewmodel by viewModels<SongViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //NavGraphWelcome()
            //MainScreen()
            NavGraphSearch()
        }
    }
}

