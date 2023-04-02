package com.example.loginviewvideo.ui.login.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginviewvideo.ui.theme.DarkGreen

@Composable
fun CustomButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(24.dp)),
        colors = ButtonDefaults.buttonColors(DarkGreen)) {
            Text(
                text = "SIGN IN",
                Modifier
                    .padding(vertical = 8.dp),
                color = Color.White)
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun CustomButtonPreview() {
    CustomButton()
}

