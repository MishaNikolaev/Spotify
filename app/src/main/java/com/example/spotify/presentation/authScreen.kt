package com.example.spotify.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotify.R
import com.example.spotify.presentation.navigation.WelcomeRoutes
import com.example.spotify.ui.theme.SpotiDark

@Composable
fun AuthScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.spot_big),
                contentDescription = "Spotify Logo",
                modifier = Modifier
                    .size(180.dp)
                    //.padding(bottom = 16.dp)
            )

            Text(
                text = "You need to register or sign in",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Spotify is a music streaming platform that offers a wide range of features to enhance your listening experience. With Spotify, you can access millions of songs, albums, and playlists from artists all over the world. ",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp, start = 10.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate(WelcomeRoutes.RegisterScreen.route)
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1DB954)
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(end = 28.dp)
                ) {
                    Text(text = "Register", color = Color.White, fontSize = 16.sp)
                }

                Text(
                    text = "Sign in",
                    fontSize = 16.sp,
                    color = SpotiDark,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            navController.navigate(WelcomeRoutes.SignInScreen.route)
                        }
                        .padding(start = 30.dp)
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable._5mag_billie_03_master675_v3_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(top=400.dp)
                .align(Alignment.CenterStart)
                .width(300.dp)
                .height(300.dp)
        )
    }
}
