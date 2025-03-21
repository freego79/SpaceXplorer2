package cz.freego.tutorial.wear.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cz.freego.tutorial.core.design.compose.animation.PersistentLottieAnimation
import cz.freego.tutorial.wear.ui.Screen

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        PersistentLottieAnimation(
            modifier = Modifier.padding(32.dp),
            assetName = "anim_rocket.lottie",
            iterations = 1,
            speed = 1f,
            onAnimationFinished = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) {
                        inclusive = true
                    }
                }
            },
            onFinishedDelay = 500L,
        )
    }
}