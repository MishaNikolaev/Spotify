package com.example.spotify.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spotify.ui.theme.fontFamily

@Composable
fun FirstScreen() {
    Text(
        text = "Hello",
        fontFamily = fontFamily,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        modifier = Modifier.padding(100.dp)
    )
}