package com.example.spotify.data.song_data

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PauseCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spotify.R
import com.example.spotify.data.Song
import com.example.spotify.data.songsList
import com.example.spotify.ui.theme.SpotiGreen
import com.example.spotify.ui.theme.SpotiLightGray
import kotlinx.coroutines.delay
@Composable
fun MediaPlayerCard(modifier: Modifier = Modifier, song: Song, previousSong: () -> Unit, nextSong: () -> Unit) {
    var songState by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(songState) {
        if (songState) {
            SongHelper.playStream(song.media)
        } else {
            SongHelper.pauseStream()
        }
    }

    Card(
        modifier = modifier
            .offset(y = (-5).dp)
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
            Icon(
                imageVector = Icons.Default.SkipPrevious,
                contentDescription = "previous",
                modifier = Modifier.padding(start = 10.dp)
                    .size(28.dp)
                    .clickable {
                        previousSong()
                    }
            )
            Icon(
                painter = if (songState) {
                    painterResource(id = R.drawable.pause)
                } else {
                    painterResource(id = R.drawable.play_button_arrowhead)
                },
                contentDescription = "Pause/Play",
                modifier = Modifier
                    .padding(start = 25.dp)
                    .size(20.dp)
                    .clickable {
                        songState = !songState
                    }
            )
            Icon(
                imageVector = Icons.Default.SkipNext,
                contentDescription = "next",
                modifier = Modifier.padding(start = 20.dp)
                    .size(28.dp)
                    .clickable {
                        nextSong()
                    }
            )
        }
    }

    DisposableEffect(song.media) {
        onDispose {
            songState = false
            SongHelper.releasePlayer()
        }
    }

    if (showDialog) {
        SongDialog(song = song, onDismiss = { showDialog = false }, previousSong = previousSong, nextSong = nextSong)
    }
}


@Composable
fun SongDialog(song: Song, onDismiss: () -> Unit, previousSong: () -> Unit, nextSong: () -> Unit) {
    var currentPosition by remember { mutableStateOf(0) }
    val duration = remember { SongHelper.getDuration() }
    var isPlaying by remember { mutableStateOf(true) }

    LaunchedEffect(song.media) {
        while (true) {
            val position = SongHelper.getCurrentPosition()
            currentPosition = position / 1000
            delay(500)
        }
    }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = SpotiLightGray)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    model = song.imageUrl,
                    contentDescription = "Song thumbnail",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = song.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = song.artist,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Slider(
                    value = currentPosition.toFloat(),
                    onValueChange = { newValue ->
                        currentPosition = newValue.toInt()
                    },
                    onValueChangeFinished = {
                        SongHelper.seekTo(currentPosition * 1000)
                    },
                    valueRange = 0f..(duration / 1000).toFloat(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = SpotiGreen,
                        activeTrackColor = SpotiGreen,
                        inactiveTrackColor = SpotiGreen.copy(alpha = 0.24f)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.SkipPrevious,
                        contentDescription = "Previous Song",
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                previousSong()
                            }
                    )
                    Spacer(modifier = Modifier.width(36.dp))
                    Icon(
                        painter = if (isPlaying) {
                            painterResource(id = R.drawable.pause)
                        } else {
                            painterResource(id = R.drawable.play_button_arrowhead)
                        },
                        contentDescription = "Pause/Play",
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                isPlaying = !isPlaying
                                if (isPlaying) {
                                    SongHelper.playStream(song.media)
                                } else {
                                    SongHelper.pauseStream()
                                }
                            }
                    )


                    Spacer(modifier = Modifier.width(36.dp))
                    Icon(
                        imageVector = Icons.Default.SkipNext,
                        contentDescription = "Next Song",
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                nextSong()
                            }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = {
                        onDismiss()
                    }) {
                        Text("Закрыть")
                    }
                }
            }
        }
    }
}


object MediaPlayerSingleton {
    private var mediaPlayer: MediaPlayer? = null

    fun getMediaPlayer(): MediaPlayer {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
        }
        return mediaPlayer!!
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}