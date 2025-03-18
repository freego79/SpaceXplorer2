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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun RocketSimpleItem(
    modifier: Modifier = Modifier,
    rocket: RocketDto,
) {
    Card(
        modifier = modifier
            .size(width = 150.dp, height = 200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            rocket.flickrImages?.let {
                if (it.isNotEmpty()) {
                    Image(
                        painter = rememberAsyncImagePainter(it[0]),
                        contentDescription = rocket.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            rocket.name?.let { name ->
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
private fun RocketSimpleItemPreview() {
    SpaceXplorerTheme {
        Surface {
            RocketSimpleItem(
                rocket = RocketDto(
                    name = "Falcon",
                    type = null,
                    id = "001",
                    wikipedia = null,
                    mass = null,
                    flickrImages = null,
                    costPerLaunch = null,
                    firstStage = null,
                    description = "Description",
                    firstFlight = null,
                    landingLegs = null,
                    secondStage = null,
                    active = true,
                    height = null,
                    stages = 2,
                    boosters = 2,
                    diameter = null,
                    payloadWeights = null,
                    successRatePct = 3,
                    company = "SpaceX",
                    country = "US",
                    engines = null,
                )
            )
        }
    }
}