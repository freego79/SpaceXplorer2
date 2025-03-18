package cz.freego.tutorial.core.design.compose.animation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.compose.runtime.mutableIntStateOf
import kotlinx.coroutines.delay


@Composable
fun PersistentLottieAnimation(
    assetName: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    iterations: Int = Int.MAX_VALUE,
    speed: Float = 1F,
    onAnimationFinished: (() -> Unit)? = null,
    onFinishedDelay: Long = 0L,
) {
    // Načtení Lottie kompozice z assets
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(assetName))

    // Vytvoříme LottieAnimatable, který ovládá průběh animace
    val lottieAnimatable = rememberLottieAnimatable()

    // Uložíme průběh animace pomocí rememberSaveable, aby přežil změnu konfigurace (např. otočení)
    var savedProgress by rememberSaveable { mutableFloatStateOf(0f) }

    // Uložíme průběh animace pomocí rememberSaveable, aby přežil změnu konfigurace (např. otočení)
    var savedIteration by rememberSaveable { mutableIntStateOf(1) }

    // Spuštění animace s nastavením počáteční hodnoty
    LaunchedEffect(composition) {
        if (composition != null) {
            lottieAnimatable.animate(
                composition = composition,
                initialProgress = savedProgress, // nastavíme počáteční průběh
                iteration = savedIteration, // nastavíme počáteční iteraci
                iterations = iterations, // počet opakování animace
                speed = speed,
            )
        }
    }

    // Sledujeme průběh animace a ukládáme ho pro progress
    LaunchedEffect(lottieAnimatable.progress) {
        snapshotFlow { lottieAnimatable.progress }
            .collect { progress ->
                savedProgress = progress  // ulož aktuální stav progress
                if (progress == 1f) {
                    // progress == 1f indikuje konec animace
                    delay(onFinishedDelay)
                    onAnimationFinished?.invoke()
                }
            }
    }

    // Sledujeme průběh animace a ukládáme ho pro iteraci
    LaunchedEffect(lottieAnimatable.iteration) {
        snapshotFlow { lottieAnimatable.iteration }
            .collect { iteration ->
                savedIteration = iteration  // ulož aktuální stav iteration
            }
    }

    LottieAnimation(
        composition = composition,
        progress = { lottieAnimatable.progress },
        modifier = modifier.background(backgroundColor),
    )
}
