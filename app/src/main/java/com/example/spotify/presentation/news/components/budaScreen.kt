package com.example.spotify.presentation.news.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotify.R
import com.example.spotify.data.Song
import com.example.spotify.data.song_data.SongsListPhonk
import com.example.spotify.presentation.news.MediaPlayerCardPhonk
import com.example.spotify.ui.theme.SpotiLightGray


@Composable
fun BudaScreen(navController: NavController, songsList: List<Song>) {
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
        AlbumBudaScreen()

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

            MediaPlayerCardPhonk(
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

val budaList: List<Song> = listOf(

    Song(
        imageUrl = "https://lastfm.freetls.fastly.net/i/u/ar0/504881b17d3ecb5bdf0d3c0ae1d57b9e.jpg",
        media = "https://rus.hitmotop.com/get/music/20230424/OG_Buda_-_Sandjejj_Servis_75848919.mp3",
        duration = "2:09",
        title = "Сандэй Сервис",
        artist = "OG Buda"
    ),

    Song(
        imageUrl = "https://lastfm.freetls.fastly.net/i/u/ar0/504881b17d3ecb5bdf0d3c0ae1d57b9e.jpg",
        media = "https://rus.hitmotop.com/get/music/20230424/OG_Buda_-_Interesno_75848921.mp3",
        duration = "2:40",
        title = "Интересно",
        artist = "OG Buda"
    ),

    Song(
        imageUrl = "https://lastfm.freetls.fastly.net/i/u/ar0/504881b17d3ecb5bdf0d3c0ae1d57b9e.jpg",
        media = "https://rus.hitmotop.com/get/music/20230424/OG_Buda_MAYOT_-_Kasanie_75848922.mp3",
        duration = "2:32",
        title = "Касание",
        artist = "OG Buda"
    ),

    Song(
        imageUrl = "https://lastfm.freetls.fastly.net/i/u/ar0/504881b17d3ecb5bdf0d3c0ae1d57b9e.jpg",
        media = "https://rus.hitmotop.com/get/music/20230424/OG_Buda_YUNGWAY_-_Bljess_75848926.mp3",
        duration = "2:57",
        title = "Блэсс",
        artist = "OG Buda"
    ),

    Song(
        imageUrl = "https://lastfm.freetls.fastly.net/i/u/ar0/504881b17d3ecb5bdf0d3c0ae1d57b9e.jpg",
        media = "https://rus.hitmotop.com/get/music/20230801/MAYOT_-_proshhajj_76470291.mp3",
        duration = "2:36",
        title = "Прощай",
        artist = "MAYOT"
    )
)


@Composable
fun AlbumBudaScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(1f)
            .background(Color(0xFF768389))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.buda),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Скучаю, но работаю",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {

            Image(
                painter = painterResource(id = R.drawable._23223),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "OG Buda · 2023",
                style = TextStyle(
                    color = SpotiLightGray,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=5.dp)
            )
        }
    }
}
