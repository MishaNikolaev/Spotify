package com.example.spotify.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotify.R
import com.example.spotify.presentation.navigation.WelcomeRoutes
import com.example.spotify.ui.theme.SpotiBlue
import com.example.spotify.ui.theme.SpotiDark
import com.example.spotify.ui.theme.SpotiGreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun RegisterScreen(navController: NavController) {

    val auth = Firebase.auth

    var emailState = remember { mutableStateOf("") }
    var fullName = remember { mutableStateOf("") }
    var passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.spot_big),
            contentDescription = "Spotify Logo",
            modifier = Modifier.size(140.dp),
            alignment = Alignment.TopCenter
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Register",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = SpotiDark,
            textAlign = TextAlign.Center
        )

        Row(modifier = Modifier.padding(top = 20.dp)) {

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "If You Need Any Support",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = SpotiDark,
                modifier = Modifier.padding(top = 15.dp)
            )
            TextButton(onClick = { /*TODO*/ }) {
                Text("Click Here", color = SpotiGreen)
            }
        }

        OutlinedTextField(
            value = fullName.value,
            onValueChange = { fullName.value = it },
            label = {
                Text(
                    "Full Name",
                    fontWeight = FontWeight.Normal,
                    color = SpotiDark,
                    fontSize = 14.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))



        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = {
                Text(
                    "Enter Email",
                    fontWeight = FontWeight.Normal,
                    color = SpotiDark,
                    fontSize = 14.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = {
                Text(
                    "Password",
                    fontWeight = FontWeight.Normal,
                    color = SpotiDark,
                    fontSize = 14.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                signUp(auth, emailState.value, passwordState.value)
                navController.navigate(WelcomeRoutes.SignInScreen.route)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(SpotiGreen)
        ) {
            Text("Create Account", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Or", color = SpotiDark)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Sign-In"
                )
            }
            Spacer(modifier = Modifier.width(28.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Apple Sign-In"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.padding(top = 20.dp)) {

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Do You Have An Account?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = SpotiDark,
                modifier = Modifier.padding(top = 15.dp)
            )
            TextButton(onClick = {
                navController.navigate(WelcomeRoutes.SignInScreen.route)
            }) {
                Text("Sign In", color = SpotiBlue)
            }
        }
    }
}

private fun signUp(auth : FirebaseAuth, email: String, password: String){
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener{
            if (it.isSuccessful){
                Log.d("MyLog", "Sign Up successful")
            }
            else{
                Log.d("MyLog", "Sign Up exception")
            }
        }
}