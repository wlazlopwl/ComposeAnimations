package com.appdevpwl.composeanimations.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun InfiniteTransitionScreen() {
    Box {
        val infiniteTransition = rememberInfiniteTransition()

        val color1 = Color.Gray
        val color2 = Color.Green

        val firstRect by infiniteTransition.animateColor(
            initialValue = color1,
            targetValue = color2,
            animationSpec = infiniteRepeatable(
                animation = tween(DURATION_MILLIS),
                repeatMode = RepeatMode.Reverse
            )
        )

        val secondRect by infiniteTransition.animateColor(
            initialValue = color2,
            targetValue = color1,
            animationSpec = infiniteRepeatable(
                animation = tween(DURATION_MILLIS),
                repeatMode = RepeatMode.Reverse
            )
        )

        val thirdRect by infiniteTransition.animateColor(
            initialValue = color1,
            targetValue = color2,
            animationSpec = infiniteRepeatable(
                animation = tween(DURATION_MILLIS),
                repeatMode = RepeatMode.Restart
            )
        )

        val fourthRect by infiniteTransition.animateColor(
            initialValue = color2,
            targetValue = color1,
            animationSpec = infiniteRepeatable(
                animation = tween(DURATION_MILLIS),
                repeatMode = RepeatMode.Restart
            )
        )

        Column {
            Row {
                Canvas(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(100.dp)

                ) {
                    drawRect(color = firstRect)
                }

                Canvas(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(100.dp)

                ) {
                    drawRect(color = secondRect)
                }
            }

            Row {
                Canvas(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(100.dp)

                ) {
                    drawRect(color = thirdRect)
                }

                Canvas(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(100.dp)

                ) {
                    drawRect(color = fourthRect)
                }
            }
        }
    }
}

const val DURATION_MILLIS = 1500
