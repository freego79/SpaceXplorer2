package cz.freego.tutorial.wear.ui.screen.crew

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import cz.freego.tutorial.core.design.compose.layout.DefaultErrorContent
import cz.freego.tutorial.core.design.compose.layout.LoadingLayout
import cz.freego.tutorial.core.design.theme.phone.ColorsDark
import cz.freego.tutorial.core.presentation.CrewViewModel
import cz.freego.tutorial.core.utils.RequestState

@Composable
fun CrewDetailScreen(
    id: String,
    viewModel: CrewViewModel = hiltViewModel()
) {
    val crewState by viewModel.crew.collectAsState()

    LaunchedEffect(id) {
        viewModel.fetchCrew(id)
    }

    LoadingLayout(
        requestState = crewState,
        errorContent = {
            DefaultErrorContent(
                message = (crewState as RequestState.Error).message,
                onRetry = { viewModel.fetchCrew(id) },
            )
        }
    ) { crew ->
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = crew.name ?: "",
                    style = MaterialTheme.typography.titleSmall,
                    color = ColorsDark.onSurface,
                )
                Spacer(Modifier.height(8.dp))
                crew.image?.let {
                    Image(
                        painter = rememberAsyncImagePainter(crew.image),
                        contentDescription = crew.name ?: "",
                        modifier = Modifier
                            .size(width = 64.dp, height = 96.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.tertiary),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Agentura: ${crew.agency ?: ""}",
                    style = MaterialTheme.typography.bodySmall,
                    color = ColorsDark.onSurface.copy(alpha = .75f),
                )
                Text(
                    text = "Počet letů: ${crew.launches?.size ?: "-"}",
                    style = MaterialTheme.typography.bodySmall,
                    color = ColorsDark.onSurface.copy(alpha = .75f),
                )
                Text(
                    text = "Status: ${crew.status ?: ""}",
                    style = MaterialTheme.typography.bodySmall,
                    color = ColorsDark.onSurface.copy(alpha = .75f),
                )
            }
        }
    }

}