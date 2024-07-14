package com.example.spotify.presentation.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.spotify.R
import com.example.spotify.data.Song
import com.example.spotify.data.song_data.SongDialog
import com.example.spotify.data.song_data.SongHelper
import com.example.spotify.data.song_data.SongsListPhonk
import com.example.spotify.ui.theme.SpotiGreen
import com.example.spotify.ui.theme.SpotiLightGray

@Composable
fun RapScreen(songsList: List<Song>){
    var searchSongState = remember { mutableStateOf("") }
    var selectedSongIndex by remember { mutableStateOf(0) }
    val selectedSong = songsList[selectedSongIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SpotiLightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.spot_big),
            contentDescription = "Spotify Logo",
            modifier = Modifier
                .size(140.dp)
                .padding(top = 20.dp),
            alignment = Alignment.Center
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp)
        ) {
            Column {
                SongsListPhonk(
                    songsList = songsList,
                    onSongSelected = { song ->
                        selectedSongIndex = songsList.indexOf(song)
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            MediaPlayerCardRap(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Transparent),
                song = selectedSong,
                previousSong = {
                    if (selectedSongIndex > 0) {
                        selectedSongIndex--
                    }
                },
                nextSong = {
                    if (selectedSongIndex < songsList.size - 1) {
                        selectedSongIndex++
                    }
                }
            )
        }
    }
}


@Composable
fun MediaPlayerCardRap(
    modifier: Modifier = Modifier,
    song: Song,
    previousSong: () -> Unit,
    nextSong: () -> Unit
) {
    var isPlaying by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            SongHelper.playStream(song.media)
            SongHelper.setOnCompletionListener {
                nextSong()
            }
        } else {
            SongHelper.pauseStream()
        }
    }


    Card(
        modifier = modifier
            .offset(y = (-50).dp)
            .clickable { showDialog = true },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = SpotiLightGray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = song.imageUrl,
                contentDescription = "Song thumbnail",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = song.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = song.artist,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Image(
                painter = painterResource(id = R.drawable.previous),
                contentDescription = "previous",
                modifier = Modifier
                    .padding(start = 25.dp)
                    .size(28.dp)
                    .clickable {
                        previousSong()
                    }
            )
            Icon(
                painter = if (isPlaying) {
                    painterResource(id = R.drawable.pause)
                } else {
                    painterResource(id = R.drawable.play_button_arrowhead)
                },
                contentDescription = "Pause/Play",
                tint = SpotiGreen,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .size(20.dp)
                    .clickable {
                        isPlaying = !isPlaying
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.next),
                contentDescription = "next",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(28.dp)
                    .clickable {
                        nextSong()
                    }
            )
        }
    }

    DisposableEffect(song.media) {
        onDispose {
            isPlaying = false
            SongHelper.releasePlayer()
        }
    }

    if (showDialog) {
        SongDialog(
            song = song,
            onDismiss = { showDialog = false },
            previousSong = previousSong,
            nextSong = nextSong,
            isPlaying = isPlaying,
            togglePlayingState = { isPlaying = !isPlaying }
        )
    }
}

