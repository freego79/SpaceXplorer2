package cz.freego.tutorial.core.design.compose.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun CapsuleListItem(
    modifier: Modifier = Modifier,
    capsule: CapsuleDto,
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
                Column(Modifier.weight(1f)) {
                    Text(text = capsule.serial ?: "", style = MaterialTheme.typography.headlineLarge)
                    Text(text = capsule.type ?: "", style = MaterialTheme.typography.headlineSmall)
                }
                Column(Modifier.weight(1f)) {
                    Text(
                        text = "Status: ${capsule.status ?: "-"}",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                    )
                    Text(
                        text = "Přistání (povrch): ${capsule.landLandings ?: "-"}",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                    )
                    Text(
                        text = "Přistání (voda): ${capsule.waterLandings ?: "-"}",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                    )
                    Text(
                        text = "Použito: ${capsule.reuseCount ?: "-"}",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                    )
                }
            }
            capsule.lastUpdate?.let {
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 1.dp)
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Preview
@Composable
private fun CapsuleListItemPreview() {
    SpaceXplorerTheme {
        CapsuleListItem(
            capsule = CapsuleDto(
                serial = "C106",
                type = "Dragon 1.1",
                status = "active",
                landLandings = 0,
                waterLandings = 3,
                reuseCount = 2,
                lastUpdate = "As of January 8, 2020: Arrived at Port of LA after splashdown following CRS-19 mission",
            )
        )
    }
}