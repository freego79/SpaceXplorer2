package cz.freego.tutorial.spacexplorer.ui.screen.units.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.presentation.RocketViewModel

@Composable
fun RocketsContent(viewModel: RocketViewModel = hiltViewModel()) {
    val rockets: LazyPagingItems<RocketDto> = viewModel.rockets.collectAsLazyPagingItems()

    PagingStateHandler<RocketDto>(
        lazyType = LazyTypeEnum.LAZY_COLUMN,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = rockets.loadState,
        itemCount = rockets.itemCount
    ) {
        item { Text("ROCKETS_CONTENT") }

        items(rockets.itemCount) { index ->
            rockets[index]?.let { rocket ->
                Text(text = rocket.name ?: "")
            }
        }
    }
}
