package com.example.instagramcompose

import android.app.Activity
import android.preference.PreferenceActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramcompose.ui.theme.InstagramComposeTheme

@Composable
fun LoginScreen() {
    Box(Modifier.fillMaxSize()) {
        LoginHeader(Modifier.align(Alignment.TopEnd))
        LoginContent()
    }
}

@Composable
fun LoginContent() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Image(
            painterResource(id = R.drawable.ig_text_logo),
            contentDescription = "Instagram's text logo"
        )
    }
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