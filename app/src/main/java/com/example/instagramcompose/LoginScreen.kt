package com.example.instagramcompose

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LoginHeader(Modifier.align(Alignment.TopEnd))
        LoginBody(Modifier.align(Alignment.Center))
        LoginFooter(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun LoginFooter(modifier: Modifier) {
    Box(modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .height(1.dp)
                .background(Color(0xFFF9F9F9))
                .fillMaxWidth()
                .align(Alignment.TopStart)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(top = 24.dp, bottom = 24.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account?", color = Color.Gray)
            Text("Sign up.", color = Color(0xFF4EA8E9), modifier = Modifier.padding(start = 4.dp), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LoginBody(modifier: Modifier) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        MySpacer(space = 16)
        Email(email) { email = it }
        MySpacer(space = 4)
        Password(password) { password = it }
        MySpacer(space = 8)
        ForgotPassword(Modifier.align(Alignment.End))
        MySpacer(space = 16)
        LoginButton(isLoginEnabled)
        MySpacer(space = 16)
        LoginDivider()
        MySpacer(space = 32)
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.fb_logo),
            contentDescription = "Facebook Login",
            Modifier
                .padding(end = 8.dp)
                .size(24.dp)
        )
        Text(
            "Continue as Gabriel",
            color = Color(0xFF4EA8E9),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            "OR",
            color = Color(0xFFB5B5B5),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(18.dp)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnabled: Boolean) {
    Button(onClick = { }, enabled = loginEnabled, modifier = Modifier.fillMaxWidth()) {
        Text("Login")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun Password(password: String, onTextChange: (String) -> Unit) {
    TextField(value = password, onValueChange = { onTextChange(it) }, Modifier.fillMaxWidth(), label = { Text("Phone number, username or email") })
}

@Composable
fun Email(email: String, onTextChange: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChange(it) }, Modifier.fillMaxWidth(), label = { Text("Password") })
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Box(modifier.height(100.dp)) {
        Image(
            painter = painterResource(R.drawable.ig_text_logo),
            contentDescription = "Logo",
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun MySpacer(space: Int) {
    Spacer(Modifier.size(space.dp))
}

@Composable
fun LoginHeader(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close App",
        modifier.clickable { activity.finish() }
    )
}