package com.appdevpwl.composeanimations.view

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


@Composable
fun AnimatedVisibilityScreen() {
    Box(modifier = Modifier.padding(10.dp))
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }
        val density = LocalDensity.current
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.5f
            ),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(30.dp)
                    .background(Color.Gray)
            )
        }
        StartAnimateButton {
            visible = !visible
        }
    }
}



