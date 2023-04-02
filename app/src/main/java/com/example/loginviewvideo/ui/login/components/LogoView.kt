package com.example.loginviewvideo.ui.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginviewvideo.R
import com.example.loginviewvideo.ui.theme.DarkGreen


@Composable
fun LogoView () {
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.95f),
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun LogoViewPreview() {
    LogoView()
}