package com.example.spotify.presentation.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.spotify.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun ComedyScreen(navController: NavController){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.spot_big),
            contentDescription = "Spotify Logo",
            modifier = Modifier
                .size(140.dp),
        )
        Spacer(modifier = Modifier.height(20.dp))
        YouTubePlayerComedy(youtubeVideoId = "1H2_LrDGMOg", lifecycleOwner = LocalLifecycleOwner.current)
        Spacer(modifier = Modifier.height(20.dp))
        YouTubePlayerComedy(youtubeVideoId = "EY4Y96tWh4g", lifecycleOwner = LocalLifecycleOwner.current)

        Spacer(modifier = Modifier.height(20.dp))
        YouTubePlayerComedy(youtubeVideoId = "VmT6chc7NtQ", lifecycleOwner = LocalLifecycleOwner.current)

        Spacer(modifier = Modifier.height(20.dp))
        YouTubePlayerComedy(youtubeVideoId = "Y-n6gMvNyfs", lifecycleOwner = LocalLifecycleOwner.current)

        Spacer(modifier = Modifier.height(20.dp))
        YouTubePlayerComedy(youtubeVideoId = "-NzHA4aMYw8", lifecycleOwner = LocalLifecycleOwner.current)
        Spacer(modifier = Modifier.height(40.dp))

    }
}

@Composable
fun YouTubePlayerComedy(
    youtubeVideoId: String,
    lifecycleOwner: LifecycleOwner
) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { context ->
            YouTubePlayerView(context = context).apply {
                lifecycleOwner.lifecycle.addObserver(this)

                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadVideo(youtubeVideoId, 0f)
                    }
                })
            }
        }
    )
}