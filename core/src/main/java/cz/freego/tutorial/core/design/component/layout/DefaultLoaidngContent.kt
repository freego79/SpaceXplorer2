package cz.freego.tutorial.core.design.component.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.design.component.animation.PersistentLottieAnimation

@Composable
fun DefaultLoaidngContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    animSize: Dp = 96.dp,
    assetName: String = "anim_rocket.lottie",
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        PersistentLottieAnimation(
            modifier = Modifier.size(animSize),
            assetName = assetName,
        )
    }
}