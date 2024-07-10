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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.example.spotify.R
import com.example.spotify.data.song_data.MediaPlayerCard
import com.example.spotify.data.song_data.SongsList
import com.example.spotify.data.songsList
import com.example.spotify.presentation.HomeScreen
import com.example.spotify.presentation.navigation.WelcomeRoutes
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiGreen
import com.example.spotify.ui.theme.SpotiLightGray

@Composable
fun NewsScreen(){
    Column(modifier = Modifier
        //.verticalScroll(rememberScrollState())
        .fillMaxSize()
        .background(SpotiLightGray)
        .padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        TopGenresSection()
        Spacer(modifier = Modifier.height(16.dp))
        PopularPodcastCategoriesSection()
        Spacer(modifier = Modifier.height(16.dp))
        BrowseAllSection()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        modifier = Modifier
            .fillMaxWidth()
            .background((SpotiGreen), shape = MaterialTheme.shapes.small)
            .padding(12.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Поиск",
                tint = Color.White,
                modifier = Modifier
                    .padding()
                    .clickable {

                    }
            )
        },
        placeholder = {
            Text(text = "Artists, songs, playlists", color = Color.White)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        )
    )
}

@Composable
fun TopGenresSection() {
    Column() {

        Text(
            text = "Your top genres",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = SpotiDark,
            modifier = Modifier.padding()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
                    .padding(16.dp)
                    .clickable {

                    },
            ) {
                Text(
                    text = "Phonk",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                )
                Image(
                    painter = painterResource(id = R.drawable.jf7_opr81j0),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(top = 15.dp)
                        .align(Alignment.BottomEnd)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFEF212E))
                    .padding(16.dp)
                    .clickable {

                    }
            ) {
                Text(
                    text = "Rap",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                )
                Image(
                    painter = painterResource(id = R.drawable.whole_lotta_red_wallpaper_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}

@Composable
fun PopularPodcastCategoriesSection() {
    Column() {

        Text(
            text = "Popular podcast categories",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = SpotiDark,
            modifier = Modifier.padding()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
                    .padding(16.dp)
                    .clickable {

                    },
            ) {
                Text(
                    text = "Phonk",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                )
                Image(
                    painter = painterResource(id = R.drawable.jf7_opr81j0),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(top = 15.dp)
                        .align(Alignment.BottomEnd)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFEF212E))
                    .padding(16.dp)
                    .clickable {

                    }
            ) {
                Text(
                    text = "Rap",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                )
                Image(
                    painter = painterResource(id = R.drawable.whole_lotta_red_wallpaper_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}

@Composable
fun BrowseAllSection() {
    Column() {

        Text(
            text = "Browse all",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = SpotiDark,
            modifier = Modifier.padding()
        )
        Spacer(modifier = Modifier.height(10.dp))

    }
}