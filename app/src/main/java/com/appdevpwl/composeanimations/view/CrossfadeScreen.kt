package com.appdevpwl.composeanimations.view

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CrossfadeScreen() {

    var state by remember {
        mutableStateOf(false)
    }

    Column {
        Box {

            Crossfade(
                targetState = state,
                animationSpec = tween(3000, easing = FastOutSlowInEasing)
            ) {
                when (it) {
                    false -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(Color.Yellow)
                        )

                    }
                    true -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(Color.Green)
                        )
                    }
                }

            }

        }
        StartAnimateButton {
            state = !state
        }
    }

}





