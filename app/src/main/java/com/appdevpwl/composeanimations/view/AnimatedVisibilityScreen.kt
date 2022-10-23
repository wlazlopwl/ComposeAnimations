package com.appdevpwl.composeanimations.view

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimatedVisibilityScreen() {
    Box(modifier = Modifier.padding(10.dp))
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutVertically ()
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Gray)
            )
        }
        StartAnimateButton {
            visible = !visible
        }
    }
}



