**I tried to do application with media3 and i did this, but this project is poor because he has just media player and firebase without architecture pattern. 
Maybe this app will be example for design or media player.**

At first, there are auth screens (design and nothing at all). You can find this screens in folder presentation -> firstScreen.kt (or chooseThemeScreen.kt)

<img src="https://github.com/MishaNikolaev/Spotify/blob/feature/num1.jpg" width="300" height="600"> <img src="https://github.com/MishaNikolaev/Spotify/blob/feature/num2.jpg" width="300" height="600">

Next is the auth screen. There are 2 screens: sign up (RegisterScreen.kt) and sign in (SignInScreen.kt). I did this with Firebase. User who register in sign up screen can sign in with his data.
``` Kotlin
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
```

P.S. I disabled sign in screen that i can fast forward to main part of app ( i didn't disable showing auth pages).

```Kotlin
  private fun signIn(auth : FirebaseAuth, email: String, password: String){
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener{
            if (it.isSuccessful){
                Log.d("MyLog", "Sign In successful")
            }
            else{
                Log.d("MyLog", "Sign In exception")
            }
        }
}
```

<img src="https://github.com/MishaNikolaev/Spotify/blob/feature/num3.jpg" width="300" height="600"> <img src="https://github.com/MishaNikolaev/Spotify/blob/feature/num4.jpg" width="300" height="600"> <img src="https://github.com/MishaNikolaev/Spotify/blob/feature/num5.jpg" width="300" height="600">
