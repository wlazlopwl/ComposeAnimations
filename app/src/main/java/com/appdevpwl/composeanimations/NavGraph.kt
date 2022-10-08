package com.appdevpwl.composeanimations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appdevpwl.composeanimations.view.*

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.AnimatedVisibility.route
        ) {
            AnimatedVisibilityScreen()
        }
        composable(
            route = Screen.AnimatedContent.route
        ) {
            AnimatedContentScreen()
        }
        composable(
            route = Screen.Crossfade.route
        ) {
            CrossfadeScreen()
        }
        composable(
            route = Screen.AnimateAsState.route
        ) {
            AnimateAsStateScreen()
        }
    }
}



