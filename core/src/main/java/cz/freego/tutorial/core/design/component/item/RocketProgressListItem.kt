package cz.freego.tutorial.core.design.component.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.design.component.animation.PersistentLottieAnimation
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun RocketProgressListItem(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
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
        RocketProgressListItem()
    }
}