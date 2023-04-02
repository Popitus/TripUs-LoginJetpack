package com.example.loginviewvideo.ui.utils

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

sealed class InputType(
    val label: String,
    val icon: ImageVector,
    val keyboardOption: KeyboardOptions,
    val visualTransformation: VisualTransformation
){
    object Name: InputType(
        label = "Username",
        icon = Icons.Default.Person,
        keyboardOption = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Password: InputType(
        label = "Password",
        icon = Icons.Default.Person,
        keyboardOption = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
        visualTransformation = VisualTransformation.None
    )
}
