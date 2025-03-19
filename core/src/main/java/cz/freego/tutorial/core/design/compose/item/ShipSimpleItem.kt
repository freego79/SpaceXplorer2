package cz.freego.tutorial.core.design.compose.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun ShipSimpleItem(
    modifier: Modifier = Modifier,
    ship: ShipDto,
) {
    Card(
        modifier = modifier
            .size(width = 250.dp, height = 200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.tertiary, // Plná barva
                            MaterialTheme.colorScheme.tertiary.copy(alpha = .2f) // Transparentní
                        )
                    )
                )
        ) {
            ship.image?.let {
            if (it.isNotEmpty()) {
                    Image(
                        painter = rememberAsyncImagePainter(it),
                        contentDescription = ship.name ?: "ship",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            ship.name?.let { name ->
                Text(
                    text = name,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color(0x80000000))
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShipSimpleItemPreview() {
    SpaceXplorerTheme {
        Surface {
            ShipSimpleItem(
                ship = ShipDto(
                    name = "Ship",
                    id = "001",
                )
            )
        }
    }
}