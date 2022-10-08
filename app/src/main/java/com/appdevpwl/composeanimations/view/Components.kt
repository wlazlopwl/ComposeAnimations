package com.appdevpwl.composeanimations.view

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StartAnimateButton(onCLick: ()-> Unit) {
    Button(
        onClick = { onCLick() },
        modifier = Modifier.wrapContentSize(),
    ) {
        Text(text = "Animuj")
    }
}