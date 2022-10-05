package com.appdevpwl.composeanimations

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object AnimatedVisibility: Screen(route = "animated_visibility _screen")

}