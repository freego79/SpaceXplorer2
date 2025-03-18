package cz.freego.tutorial.spacexplorer.ui.screen.units

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.presentation.DragonViewModel

@Composable
fun DragonsContent(viewModel: DragonViewModel = hiltViewModel()) {
    val dragons: LazyPagingItems<DragonDto> = viewModel.dragons.collectAsLazyPagingItems()

    PagingStateHandler<DragonDto>(
        lazyType = "column",
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = dragons.loadState,
        itemCount = dragons.itemCount
    ) {
        item { Text("DRAGONS_CONTENT") }

        items(dragons.itemCount) { index ->
            dragons[index]?.let { dragon ->
                Text(text = dragon.name ?: "")
            }
        }
    }
}
