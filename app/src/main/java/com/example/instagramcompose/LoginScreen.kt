package com.example.instagramcompose

import android.preference.PreferenceActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramcompose.ui.theme.InstagramComposeTheme

@Composable
fun LoginScreen() {
    Column() {
        LoginHeader()
        LoginContent()
    }
}

@Composable
fun LoginContent() {
    Column(Modifier.fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.ig_text_logo),
            contentDescription = "Instagram's text logo"
        )


    }
}

@Composable
fun LoginHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.End
    ) {
        Icon(imageVector = Icons.Default.Close, contentDescription = "Close App")
    }
}