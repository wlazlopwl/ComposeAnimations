package com.appdevpwl.composeanimations.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun UpdateTransitionScreen() {

    var titlePosition by remember { mutableStateOf(Position.FIRST.name) }

    var rectPosition by remember { mutableStateOf(Position.FIRST) }

    val transition = updateTransition(
        targetState = rectPosition,
        label = "Color"
    )

    val animatedColor: Color by transition.animateColor(
        transitionSpec = {
            tween(2000)
        }, label = ""

    ) { rectPosition ->
        when (rectPosition) {
            Position.FIRST -> Color.Green
            Position.SECOND -> Color.Blue
            Position.THIRD -> Color.Gray
            Position.FOURTH -> Color.Black
        }
    }

    val animatedOffset: Offset by transition.animateOffset(
        transitionSpec = {
            tween(2000)
        }, label = ""

    ) { rectPosition ->
        when (rectPosition) {
            Position.FIRST -> Offset(0F, 0F)
            Position.SECOND -> Offset(20F, 20F)
            Position.THIRD -> Offset(40F, 40F)
            Position.FOURTH -> Offset(50F, 50F)
        }
    }

    Column {
        Title(text = "Actual position : $titlePosition")

        Canvas(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(100.dp)

        ) {
            drawRect(
                color = animatedColor,
                topLeft = animatedOffset
            )
        }

        StartAnimateButton {
            rectPosition = when (rectPosition) {
                Position.FIRST -> {
                    Position.SECOND.also {
                        titlePosition = it.name
                    }
                }
                Position.SECOND -> {
                    Position.THIRD.also {
                        titlePosition = it.name
                    }
                }
                Position.THIRD -> {
                    Position.FOURTH.also {
                        titlePosition = it.name
                    }
                }
                Position.FOURTH -> {
                    Position.FIRST.also {
                        titlePosition = it.name
                    }
                }
            }
        }
    }
}

enum class Position(title: String) {
    FIRST("First"),
    SECOND("Second"),
    THIRD("Third"),
    FOURTH("Fourth")
}



