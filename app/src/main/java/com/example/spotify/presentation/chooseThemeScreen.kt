package com.example.spotify.presentation

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotify.R
import com.example.spotify.presentation.navigation.WelcomeRoutes
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiGreen

@Composable
fun ChooseThemeScreen(navController: NavController) {
    var isDarkMode by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.continuephoto),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.spot_big),
            contentDescription = "Spotify Logo",
            modifier = Modifier.align(Alignment.TopCenter)
                .size(180.dp)
                .padding(top = 16.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Choose mode",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(top = 140.dp, bottom = 30.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            ) {
                SpotiCardOption(
                    painter = painterResource(id = R.drawable.moonicon),
                    text = "Dark mode",
                    isSelected = isDarkMode,
                    onClick = { isDarkMode = true }
                )
                Spacer(modifier = Modifier.width(16.dp))

                SpotiCardOption(
                    painter = painterResource(id = R.drawable.sunincon),
                    text = "Light Mode",
                    isSelected = !isDarkMode,
                    onClick = { isDarkMode = false }
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    navController.navigate(WelcomeRoutes.AuthScreen.route)
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SpotiGreen
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Continue", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun SpotiCardOption(
    painter: Painter,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(100.dp)
            .clickable { onClick() }
            .background(
                color = if (isSelected) SpotiGreen else SpotiDark,
                shape = CircleShape
            )
            .padding(16.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = text,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}