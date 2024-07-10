package com.example.spotify.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotify.data.song_data.SongHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SongViewModel: ViewModel() {
    private val _songState = MutableStateFlow(false)
    val songState: StateFlow<Boolean> = _songState

    fun playSong() {
        _songState.value = true
        SongHelper.playStream("")
    }

    fun pauseSong() {
        _songState.value = false
        SongHelper.pauseStream()
    }

    fun toggleSongState() {
        if (_songState.value) {
            pauseSong()
        } else {
            playSong()
        }
    }
}