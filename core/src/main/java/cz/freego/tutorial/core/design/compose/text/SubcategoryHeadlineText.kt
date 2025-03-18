package cz.freego.tutorial.core.design.compose.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun SubcategoryHeadlineText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surfaceContainer, // Plná barva
                        MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0f) // Transparentní
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 4.dp),
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.secondary,
    )
}

@Preview
@Composable
private fun SubcategoryHeadlineTextPreview() {
    SpaceXplorerTheme {
        SubcategoryHeadlineText(text = "Popisek subkategorie")
    }
}