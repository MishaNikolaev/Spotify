package com.example.spotify.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotify.R
import com.example.spotify.data.Song
import com.example.spotify.data.song_data.MediaPlayerCard
import com.example.spotify.data.song_data.SongCard
import com.example.spotify.data.song_data.SongsList
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiGreen
import com.example.spotify.ui.theme.SpotiLightGray

@Composable
fun HomeScreen(songsList: List<Song>) {
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
            SongsList(
                songsList = songsList,
                onSongSelected = { song ->
                    selectedSongIndex = songsList.indexOf(song)
                }
            )

            MediaPlayerCard(
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