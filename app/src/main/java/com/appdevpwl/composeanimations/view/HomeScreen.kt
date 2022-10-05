package com.appdevpwl.composeanimations.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
    Box(modifier = Modifier.padding(10.dp))
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val menus = listOf<String>("Test1", "Test2")
        Menu(menus = menus)
    }
}

@Composable
fun Menu(
    menus: List<String>
) {
    Column {
        menus.forEachIndexed { index, item ->
            MenuItem(
                text = item,
                height = 50.dp
            )
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}