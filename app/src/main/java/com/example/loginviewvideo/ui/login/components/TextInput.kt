package com.example.loginviewvideo.ui.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginviewvideo.ui.theme.Shapes
import com.example.loginviewvideo.ui.utils.InputType

@Composable
fun TextInput(
    inputType: InputType,
    focusRequest: FocusRequester? = null,
    keyboardActions: KeyboardActions
) {

    // Properties
    var value by remember { mutableStateOf("") }

    // Components
    TextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier.fillMaxWidth().focusRequester(focusRequest ?: FocusRequester()),
        leadingIcon = { Icon(imageVector = inputType.icon, contentDescription = "")},
        label = { Text(text = inputType.label)},
        shape = Shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        keyboardOptions = inputType.keyboardOption,
        visualTransformation = inputType.visualTransformation,
        keyboardActions = keyboardActions
    )

}

@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    TextInput(inputType = InputType.Name, keyboardActions = KeyboardActions(onDone = { passwordFocusRequester.requestFocus() }))
}