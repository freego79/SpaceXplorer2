package cz.freego.tutorial.core.design.component.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.design.component.animation.PersistentLottieAnimation
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun RocketProgressListItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        PersistentLottieAnimation(
            modifier = Modifier.size(64.dp),
            assetName = "anim_rocket.lottie",
        )
    }
}

@Preview
@Composable
private fun RocketProgressListItemPreview() {
    SpaceXplorerTheme {
        Surface {
            RocketProgressListItem()
        }
    }
}

@Preview
@Composable
private fun RocketProgressListItemPreview2() {
    SpaceXplorerTheme {
        Surface {
            RocketProgressListItem(modifier = Modifier.wrapContentSize())
        }
    }
}