package cz.freego.tutorial.core.design.compose.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun CrewListItem(
    modifier: Modifier = Modifier,
    crewMember: CrewMemberDto,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(
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
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(crewMember.image),
                contentDescription = crewMember.name,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.tertiary),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = crewMember.name ?: "", style = MaterialTheme.typography.titleLarge)
                Text(text = "Agentura: ${crewMember.agency}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Status: ${crewMember.status}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview
@Composable
private fun CrewListItemPreview() {
    SpaceXplorerTheme {
        CrewListItem(
            crewMember = CrewMemberDto(
                id = "0001",
                name = "John Doe",
                agency = "NASA",
                status = "active",
            )
        )
    }
}