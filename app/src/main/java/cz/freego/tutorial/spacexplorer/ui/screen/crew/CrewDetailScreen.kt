package cz.freego.tutorial.spacexplorer.ui.screen.crew

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import cz.freego.tutorial.core.design.compose.layout.DefaultErrorContent
import cz.freego.tutorial.core.design.compose.layout.LoadingLayout
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = crew.name ?: "",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Agentura: ${crew.agency ?: ""}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f),
            )
            Text(
                text = "Počet letů: ${crew.launches?.size ?: "-"}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f),
            )
            Text(
                text = "Status: ${crew.status ?: ""}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f),
            )
            Spacer(Modifier.height(16.dp))
            crew.image?.let {
                Image(
                    painter = rememberAsyncImagePainter(crew.image),
                    contentDescription = crew.name ?: "",
                    modifier = Modifier
                        .size(width = 160.dp, height = 240.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.tertiary),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

}