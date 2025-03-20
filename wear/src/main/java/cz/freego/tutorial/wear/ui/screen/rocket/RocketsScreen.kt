package cz.freego.tutorial.wear.ui.screen.rocket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.design.theme.phone.ColorsDark
import cz.freego.tutorial.core.presentation.RocketsViewModel
import cz.freego.tutorial.wear.design.compose.item.RocketWearListItem

@Composable
fun RocketsScreen(
    navController: NavHostController,
    viewModel: RocketsViewModel = hiltViewModel()
) {
    val rockets: LazyPagingItems<RocketDto> = viewModel.rockets.collectAsLazyPagingItems()

    ScalingLazyColumn(
        modifier = Modifier.background(Color.Black).fillMaxSize()
    ) {
        item {
            Text(
                text = "Rakety",
                style = MaterialTheme.typography.titleLarge,
                color = ColorsDark.onSurface.copy(alpha = .75f),
            )
            Spacer(Modifier.height(16.dp))
        }
        items(rockets.itemCount) { index ->
            rockets[index]?.let { rocket ->
                RocketWearListItem(
                    rocket = rocket,
                    onRocketClicked = {
                        rocket.id?.let { _ ->
                            // not implemented
                        }
                    }
                )
            }
        }
    }
}