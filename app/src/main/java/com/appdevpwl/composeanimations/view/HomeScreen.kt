package com.appdevpwl.composeanimations.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appdevpwl.composeanimations.Screen


@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.padding(10.dp))
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val menus = listOf(
            "Animated Visibility",
            "Animated Content",
            "Crossfade",
            "Animate*asState"
        )

        Menu(menus = menus, navController)
    }
}

@Composable
fun Menu(
    menus: List<String>,
    navController: NavController
) {
    Column {
        menus.forEachIndexed { index, item ->
            MenuItem(
                text = item,
                height = 50.dp
            ) {
                when (index) {
                    0 -> navController.navigate(Screen.AnimatedVisibility.route)
                    1 -> navController.navigate(Screen.AnimatedContent.route)
                    2 -> navController.navigate(Screen.Crossfade.route)
                    3 -> navController.navigate(Screen.AnimateAsState.route)
                }
            }
        }
    }
}