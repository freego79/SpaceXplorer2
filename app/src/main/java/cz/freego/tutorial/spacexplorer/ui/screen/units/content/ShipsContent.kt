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
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.presentation.ShipViewModel

@Composable
fun ShipsContent(viewModel: ShipViewModel = hiltViewModel()) {
    val ships: LazyPagingItems<ShipDto> = viewModel.ships.collectAsLazyPagingItems()

    PagingStateHandler<ShipDto>(
        lazyType = "column",
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = ships.loadState,
        itemCount = ships.itemCount
    ) {
        item { Text("SHIPS_CONTENT") }

        items(ships.itemCount) { index ->
            ships[index]?.let { ship ->
                Text(text = ship.name ?: "")
            }
        }
    }
}
