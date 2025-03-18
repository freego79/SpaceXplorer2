package cz.freego.tutorial.core.design.component.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import cz.freego.tutorial.core.design.component.animation.PersistentLottieAnimation
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun DefaultErrorContent(
    message: String,
    onRetry: (() -> Unit)? = null,
    modifier: Modifier = Modifier.fillMaxSize(),
    animSize: Dp = 64.dp,
    assetName: String = "anim_error.lottie",
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
            text = message
        )
        onRetry?.let {
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { it.invoke() }) {
                Text("ZKUSIT ZNOVU")
            }
        }
    }
}

@Preview
@Composable
private fun DefaulErrorContentPreview() {
    SpaceXplorerTheme {
        Surface {
            DefaultErrorContent(
                message = "Ups, něco se pokazilo! Zkuste to později.",
                onRetry = { /* do retry */ },
            )
        }
    }
}