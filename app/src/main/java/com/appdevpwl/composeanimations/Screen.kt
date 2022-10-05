package com.appdevpwl.composeanimations

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")

}