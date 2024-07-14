package com.example.spotify.data.song_data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.spotify.data.Song
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiLightGray

@Composable
fun SongsList(songsList: List<Song>, onSongSelected: (song: Song) -> Unit) {
    var isSongSelected by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier.background(SpotiLightGray)
            .fillMaxSize()
            .padding(
                bottom = if (isSongSelected) {
                    48.dp
                } else {
                    4.dp
                }
            )
    ) {
        items(songsList) { song ->
            SongCard(song = song, onClick = {
                isSongSelected = true
                SongHelper.stopStream()
//                onSongSelected(song)
            })
        }
        item {
            Spacer(modifier = Modifier.height(54.dp))
        }
    }
}

@Composable
fun SongsListPhonk(songsList: List<Song>, onSongSelected: (song: Song) -> Unit) {
    var isSongSelected by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier.background(SpotiLightGray)
            .fillMaxSize()
            .padding(
                bottom = if (isSongSelected) {
                    48.dp
                } else {
                    4.dp
                }
            )
    ) {
        items(songsList) { song ->
            SongCard(song = song, onClick = {
                isSongSelected = true
                SongHelper.stopStream()
                onSongSelected(song)
            })
        }
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}