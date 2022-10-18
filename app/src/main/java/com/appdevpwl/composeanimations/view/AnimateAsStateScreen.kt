package com.appdevpwl.composeanimations.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun AnimateAsStateScreen() {
    var animationStateDamping by remember { mutableStateOf(AnimationState.Start) }
    var animationStateStiffness by remember { mutableStateOf(AnimationState.Start) }
    var animationStateTweenEasing by remember { mutableStateOf(AnimationState.Start) }
    var animationStateKeyFrames by remember { mutableStateOf(AnimationState.Start) }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Title(text = "spring()")
        Text(text = "DampingRatioLowBouncy")
        CreateRowSpringDamping(animationStateDamping, Spring.DampingRatioLowBouncy)
        Text(text = "DampingRatioMediumBouncy")
        CreateRowSpringDamping(animationStateDamping, Spring.DampingRatioMediumBouncy)
        Text(text = "DampingRatioHighBouncy")
        CreateRowSpringDamping(animationStateDamping, Spring.DampingRatioHighBouncy)

        Box {
            StartAnimateButton {
                animationStateDamping = when (animationStateDamping) {
                    AnimationState.Start -> AnimationState.Finish
                    AnimationState.Finish -> AnimationState.Start
                }
            }
        }

        Title(text = "spring()")
        Text(text = "StiffnessLow")
        CreateRowSpringStiffness(animationStateStiffness, Spring.StiffnessLow)
        Text(text = "StiffnessMedium")
        CreateRowSpringStiffness(animationStateStiffness, Spring.StiffnessMedium)
        Text(text = "StiffnessHigh")
        CreateRowSpringStiffness(animationStateStiffness, Spring.StiffnessHigh)

        Box {
            StartAnimateButton {
                animationStateStiffness = when (animationStateStiffness) {
                    AnimationState.Start -> AnimationState.Finish
                    AnimationState.Finish -> AnimationState.Start
                }
            }
        }

        val tween = 1000

        Title(text = "tween, easing")
        Text(text = "tween: 1000, easing: LinearEasing ")
        CreateRowSpringTweenEasing(animationStateTweenEasing, tween, easing = LinearEasing)
        Text(text = "tween: 1000, easing: LinearOutSlowInEasing ")
        CreateRowSpringTweenEasing(animationStateTweenEasing, tween, easing = LinearOutSlowInEasing)
        Text(text = "tween: 1000, easing: FastOutLinearInEasing ")
        CreateRowSpringTweenEasing(animationStateTweenEasing, tween, easing = FastOutLinearInEasing)

        Box {
            StartAnimateButton {
                animationStateTweenEasing = when (animationStateTweenEasing) {
                    AnimationState.Start -> AnimationState.Finish
                    AnimationState.Finish -> AnimationState.Start
                }
            }
        }

        Title(text = "Keyframes")
        Text(text = "200.dp.at(750) ")
        CreateRowKeyFrames(animationStateKeyFrames, tween)

        Box {
            StartAnimateButton {
                animationStateKeyFrames = when (animationStateKeyFrames) {
                    AnimationState.Start -> AnimationState.Finish
                    AnimationState.Finish -> AnimationState.Start
                }
            }
        }
    }
}

@Composable
private fun CreateRowSpringDamping(animationState: AnimationState, dampingRatio: Float) {
    val offsetAnimation: Dp by animateDpAsState(
        if (animationState == AnimationState.Start) 0.dp else 375.dp,
        spring(dampingRatio = dampingRatio),
    )
    Box(Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.LightGray)
        ) {}
        Box(
            modifier = Modifier
                .size(20.dp)
                .absoluteOffset(x = offsetAnimation)
                .background(Color.Gray)
        ) {}
    }
}

@Composable
private fun CreateRowSpringStiffness(animationState: AnimationState, stiffness: Float) {
    val offsetAnimation: Dp by animateDpAsState(
        if (animationState == AnimationState.Start) 0.dp else 375.dp,
        spring(stiffness = stiffness)
    )
    Box(Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.LightGray)
        ) {}
        Box(
            modifier = Modifier
                .size(20.dp)
                .absoluteOffset(x = offsetAnimation)
                .background(Color.Gray)
        ) {}
    }
}

@Composable
private fun CreateRowSpringTweenEasing(animationState: AnimationState, tween: Int, easing: Easing) {
    val offsetAnimation: Dp by animateDpAsState(
        if (animationState == AnimationState.Start) 0.dp else 375.dp,
        tween(durationMillis = tween, easing = easing)
    )
    Box(Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.LightGray)
        ) {}
        Box(
            modifier = Modifier
                .size(20.dp)
                .absoluteOffset(x = offsetAnimation)
                .background(Color.Gray)
        ) {}
    }
}

@Composable
private fun CreateRowKeyFrames(animationState: AnimationState, tween: Int) {
    val offsetAnimation: Dp by animateDpAsState(
        if (animationState == AnimationState.Start) 0.dp else 375.dp,
        keyframes {
            durationMillis = tween
            200.dp.at(750)
        }

        /*
        * example
        *
        *
        * keyframes {
            durationMillis = 1000
            50.dp.at(20).with(LinearEasing)
            200.dp.at(600).with(LinearOutSlowInEasing)
            250.dp.at(700).with(FastOutSlowInEasing)
        }
        *
        * */
    )
    Box(Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.LightGray)
        ) {}
        Box(
            modifier = Modifier
                .size(20.dp)
                .absoluteOffset(x = offsetAnimation)
                .background(Color.Gray)
        ) {}
    }
}

enum class AnimationState {
    Start, Finish
}