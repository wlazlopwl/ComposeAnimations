package com.appdevpwl.composeanimations

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object AnimatedVisibility : Screen(route = "animated_visibility _screen")
    object AnimatedContent : Screen(route = "animated_content_screen")
    object Crossfade : Screen(route = "crossfade_screen")
    object AnimateAsState : Screen(route = "animate_as_state_screen")
    object InfiniteScreen : Screen(route = "infinite_transition_screen")
    object UpdateTransitionScreen : Screen(route = "update_transition_screen")
}