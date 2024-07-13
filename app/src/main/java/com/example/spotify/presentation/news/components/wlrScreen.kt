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
    fun WholeLottaRedScreen (navController: NavController, songsList: List<Song>) {
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
            AlbumWLRScreen()

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

    val wlrList: List<Song> = listOf(

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_F33l_Lik3_Dyin_72097441.mp3",
            duration = "3:24",
            title = "F33l Lik3 Dyin",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Not_PLaying_72097440.mp3",
            duration = "2:10",
            title = "Not PLaying",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Die4Guy_72097439.mp3",
            duration = "2:11",
            title = "Die4Guy",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_ILoveUIHateU_72097438.mp3",
            duration = "2:15",
            title = "ILoveUIHateU",
            artist = "Playboi Carti"
        ),


        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Over_72097436.mp3",
            duration = "2:46",
            title = "Over",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Sky_72097435.mp3",
            duration = "3:13",
            title = "Sky",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Place_72097434.mp3",
            duration = "1:57",
            title = "Place",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_King_Vamp_72097433.mp3",
            duration = "3:07",
            title = "King Vamp",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_New_N3on_72097429.mp3",
            duration = "1:56",
            title = "New N3on",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Vamp_Anthem_72097428.mp3",
            duration = "2:04",
            title = "Vamp Anthem",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_Future_-_Teen_X_72097426.mp3",
            duration = "3:26",
            title = "Teen X",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_New_Tank_72097425.mp3",
            duration = "1:30",
            title = "New Tank",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Stop_Breathing_72097417.mp3",
            duration = "3:39",
            title = "Stop Breathing",
            artist = "Playboi Carti"
        ),

        Song(
            imageUrl = "https://i.ebayimg.com/images/g/Kr8AAOSwXoNlX7s7/s-l1600.jpg",
            media = "https://rus.hitmotop.com/get/music/20201226/Playboi_Carti_-_Rockstar_Made_72097415.mp3",
            duration = "3:14",
            title = "Rockstar Made",
            artist = "Playboi Carti"
        ),
    )



@Composable
fun AlbumWLRScreen() {
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
            painter = painterResource(id = R.drawable.whlr),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Whole Lotta Red",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {

            Image(
                painter = painterResource(id = R.drawable.wlr),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "Playboi Carti · 2020",
                style = TextStyle(
                    color = SpotiLightGray,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=5.dp)
            )
        }
    }
}