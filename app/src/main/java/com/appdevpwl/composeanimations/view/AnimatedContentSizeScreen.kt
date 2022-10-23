package com.appdevpwl.composeanimations.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.appdevpwl.composeanimations.R


@Composable
fun AnimatedContentSizeScreen() {
    Column {
        Box {
            Column {
                var expanded by remember {
                    mutableStateOf(false)
                }
                Image(
                    painter = painterResource(
                        id = if (expanded)
                            R.drawable.mountain
                        else
                            R.drawable.ic_launcher_background
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .background(Color.Yellow)
                        .animateContentSize(
                            tween(2000)
                        )
                )
                Button(onClick = { expanded = !expanded }) {
                    Text(if (expanded) "Ukryj" else "Pokaż")
                }
            }
        }
    }
}



