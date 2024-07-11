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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.navigation.NavController
import com.example.spotify.R
import com.example.spotify.data.song_data.MediaPlayerCard
import com.example.spotify.data.song_data.SongsList
import com.example.spotify.data.songsList
import com.example.spotify.presentation.HomeScreen
import com.example.spotify.presentation.navigation.SearchRoutes
import com.example.spotify.presentation.navigation.WelcomeRoutes
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiGreen
import com.example.spotify.ui.theme.SpotiLightGray

@Composable
fun NewsScreen(navController: NavController){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()
        .background(SpotiLightGray)
        .padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        TopGenresSection(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        PopularPodcastCategoriesSection(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        BrowseAllSection(navController = navController)
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
fun TopGenresSection(navController: NavController) {
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
                    .clickable {
                        navController.navigate(SearchRoutes.PhonkScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pxlwyse_eu_sento_gabu),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )

                Text(
                    text = "Phonk",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 55.dp)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate(SearchRoutes.RapScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ay4ki6euani),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )

                Text(
                    text = "Rap",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 60.dp)
                )
            }
        }
    }
}

@Composable
fun PopularPodcastCategoriesSection(navController: NavController) {
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
                    .clickable {
                        navController.navigate(SearchRoutes.PodcastsScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.maxresdefault),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )

                Text(
                    text = "Podcasts",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                    modifier = Modifier
                        .padding(top = 80.dp, start = 40.dp)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate(SearchRoutes.ComedyScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable._af482_eabbc68966d54c3db45a306583663890_mv2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )

                Text(
                    text = "Comedy",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SpotiLightGray,
                    modifier = Modifier
                        .padding(top = 80.dp, start = 45.dp)
                )
            }
        }
    }
}

@Composable
fun BrowseAllSection(navController: NavController) {
    Text(
        text = "Browse all",
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = SpotiDark,
        modifier = Modifier.padding()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .clickable {

                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.scale_1200),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(SpotiGreen, shape = CircleShape)
                    .size(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .clickable {

                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.frenk_sinatra_52),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(SpotiGreen, shape = CircleShape)
                    .size(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }

    }
}