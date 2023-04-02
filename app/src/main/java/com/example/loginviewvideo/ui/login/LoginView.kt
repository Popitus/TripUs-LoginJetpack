package com.example.loginviewvideo.ui.login

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.loginviewvideo.R
import com.example.loginviewvideo.ui.extensions.buildExoPlayer
import com.example.loginviewvideo.ui.extensions.buildPlayerView
import com.example.loginviewvideo.ui.login.components.CustomButton
import com.example.loginviewvideo.ui.login.components.LogoView
import com.example.loginviewvideo.ui.login.components.TextInput
import com.example.loginviewvideo.ui.utils.InputType
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding


@Composable
fun LoginView(videoUri: Uri) {
    // Properties
    val context = LocalContext.current
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    val exoplayer = remember { context.buildExoPlayer(videoUri) }

    DisposableEffect(
        AndroidView(
            factory = { it.buildPlayerView(exoplayer) },
            modifier = Modifier.fillMaxSize())
    ) {
        onDispose {
            exoplayer.release()
        }
    }

    // View
    ProvideWindowInsets {
        Column(
            modifier = Modifier
                .navigationBarsWithImePadding()
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Start your trip!", modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
                color = Color.White,
            fontSize = 28.sp,
            fontFamily = FontFamily.Monospace)
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp)
            Spacer(modifier = Modifier.size(280.dp))
            LogoView()
            TextInput(
                inputType = InputType.Name,
                keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() }),
            )
            TextInput(
                inputType = InputType.Password,
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                focusRequest = passwordFocusRequester)
            CustomButton()
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don´t have an account?",
                    color = Color.White)
                TextButton(onClick = {}) {
                    Text(
                        text = "SING UP", color = Color.LightGray)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = false)
@Composable
fun LoginViewPreview() {

    LoginView(videoUri = Uri.parse(R.raw.travels.toString()))
}