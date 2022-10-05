package com.appdevpwl.composeanimations.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MenuItem(text: String, height: Dp, onClick: ()-> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Text(text = text)
    }

}

@Preview
@Composable
fun MenuItemPreview() {
    MenuItem("Przeciąganie", 50.dp){}
}