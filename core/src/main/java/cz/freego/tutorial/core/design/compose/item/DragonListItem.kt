package cz.freego.tutorial.core.design.compose.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun DragonListItem(
    modifier: Modifier = Modifier,
    dragon: DragonDto,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.secondary.copy(alpha = .15f), // Plná barva
                            MaterialTheme.colorScheme.secondary.copy(alpha = .0f) // Transparentní
                        )
                    )
                )
                .padding(12.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(width = 120.dp, height = 100.dp)) {
                    dragon.flickrImages?.getOrNull(0)?.let {
                        Image(
                            painter = rememberAsyncImagePainter(it),
                            contentDescription = dragon.name ?: "dragon",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.tertiary),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = dragon.name ?: "", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Typ: ${dragon.type ?: ""}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                    )
                    Text(
                        text = "Aktivní: ${if (dragon.active == true) "ano" else "ne"}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                    )
                }
            }

            dragon.description?.let {
                Spacer(Modifier.height(8.dp))
                Text(text = dragon.description, style = MaterialTheme.typography.bodySmall)
            }

        }
    }
}

@Preview
@Composable
private fun DragonListItemPreview() {
    SpaceXplorerTheme {
        DragonListItem(
            dragon = DragonDto(
                id = "0001",
                name = "Dragon 1",
                type = "type",
                active = true,
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            )
        )
    }
}