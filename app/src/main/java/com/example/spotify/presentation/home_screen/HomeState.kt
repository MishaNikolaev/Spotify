package com.example.spotify.presentation.home_screen

import com.example.spotify.data.Song
import com.example.spotify.data.songsList

data class HomeState(
    val songlist: List<Song> = songsList
)