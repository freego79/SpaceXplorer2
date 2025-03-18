package cz.freego.tutorial.core.design.compose.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.design.compose.animation.PersistentLottieAnimation
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun DefaultLoaidngContent(
    modifier: Modifier = Modifier.fillMaxSize(),
    animSize: Dp = 96.dp,
    assetName: String = "anim_rocket.lottie",
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PersistentLottieAnimation(
            modifier = Modifier.size(animSize),
            assetName = assetName,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            text = "Načítá se"
        )
    }
}

@Preview
@Composable
private fun DefaultLoadingContentPreview() {
    SpaceXplorerTheme {
        Surface {
            DefaultLoaidngContent()
        }
    }
}