package cz.freego.tutorial.core.design.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(crewMember.image),
                contentDescription = crewMember.name,
                modifier = Modifier.size(72.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = crewMember.name, style = MaterialTheme.typography.titleLarge)
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
                image = "",
                wikipedia = "",
                status = "active",
                launches = listOf(),
            )
        )
    }
}