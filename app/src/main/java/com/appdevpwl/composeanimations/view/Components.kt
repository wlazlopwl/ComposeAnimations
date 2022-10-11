package com.appdevpwl.composeanimations.view

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun StartAnimateButton(onCLick: () -> Unit) {
    Button(
        onClick = { onCLick() },
        modifier = Modifier.wrapContentSize(),
    ) {
        Text(text = "Animuj")
    }
}

@Composable
fun Title(
    text: String,
    fontSize: TextUnit = 18.sp
) {
    Text(text = text, fontSize = fontSize)
}