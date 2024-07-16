package com.example.spotify.presentation.news.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.example.spotify.presentation.news.MediaPlayerCardPhonk
import com.example.spotify.ui.theme.SpotiGreen
import com.example.spotify.ui.theme.SpotiLightGray

@Composable
fun KinoScreen(navController: NavController, songsList: List<Song>) {
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
        AlbumKinoScreen()

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

val kinoList: List<Song> = listOf(

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Konchitsya_leto_55527252.mp3",
        duration = "6:04",
        title = "Кончится лето",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Zvezda_po_imeni_Solnce_55527244.mp3",
        duration = "3:24",
        title = "Звезда по имени Солнце",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Dalshe_dejjstvovat_budem_my_55527276.mp3",
        duration = "3:57",
        title = "Дальше действовать будем мы",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Mama_my_vse_soshli_s_uma_55527280.mp3",
        duration = "4:08",
        title = "Мама, мы все сошли с ума",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Zakrojj_za_mnojj_dver_ya_ukhozhu_55527265.mp3",
        duration = "4:05",
        title = "Закрой за мной дверь, я ухожу",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Aprel_55527305.mp3",
        duration = "4:41",
        title = "Апрель",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Stuk_55527267.mp3",
        duration = "3:51",
        title = "Стук",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Pachka_sigaret_55527249.mp3",
        duration = "4:29",
        title = "Пачка сигарет",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Mesto_dlya_shaga_vperjod_55527247.mp3",
        duration = "3:40",
        title = "Место для шага вперёд",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Mama-anarkhiya_55527281.mp3",
        duration = "2:44",
        title = "Мама - анархия",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Videli_noch_55527282.mp3",
        duration = "3:09",
        title = "Видели ночь",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Sledi_za_sobojj_55527271.mp3",
        duration = "4:58",
        title = "Следи за собой",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Kukushka_55527243.mp3",
        duration = "6:39",
        title = "Кукушка",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Nam_s_tobojj_55527279.mp3",
        duration = "4:50",
        title = "Нам с тобой",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Spokojjnaya_noch_55527268.mp3",
        duration = "6:24",
        title = "Спокойная ночь",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Gruppa_krovi_55527245.mp3",
        duration = "4:00",
        title = "Группа крови",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Poslednijj_gerojj_55527253.mp3",
        duration = "3:07",
        title = "Последний герой",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Trollejjbus_55527286.mp3",
        duration = "2:56",
        title = "Троллейбус",
        artist = "Кино"
    ),

    Song(
        imageUrl = "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6565942184ef197690545060_65659503dc9c9160245aca15/scale_1200",
        media = "https://rus.hitmotop.com/get/music/20180425/Kino_-_Peremen_55527255.mp3",
        duration = "4:55",
        title = "Перемен",
        artist = "Кино"
    )
)


@Composable
fun AlbumKinoScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(1f)
            .background(Color(0xFFA7585B))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.scale_1200),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Легенда",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {

            Image(
                painter = painterResource(id = R.drawable.kino),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "КИНО · 2018",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=5.dp)
            )
        }
    }
}
