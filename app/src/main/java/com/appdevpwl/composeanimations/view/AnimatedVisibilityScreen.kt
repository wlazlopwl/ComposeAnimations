package com.appdevpwl.composeanimations.view

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.5f
            ),
            exit = fadeOut()
        ) {
            Box(modifier = Modifier.width(60.dp).height(30.dp).background(Color.Gray))
            Text(
                "Hello",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }

        Button(
            onClick = { visible = !visible },
            modifier = Modifier.wrapContentSize(),
//            colors = ButtonDefaults.textButtonColors(Color.White)
        ) {
            Text(text = "Animuj")
        }
    }
}



