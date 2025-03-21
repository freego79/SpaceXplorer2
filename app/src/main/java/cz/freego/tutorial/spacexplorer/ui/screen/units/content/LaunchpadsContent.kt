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
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.presentation.LaunchpadsViewModel

@Composable
fun LaunchpadsContent(viewModel: LaunchpadsViewModel = hiltViewModel()) {
    val launchpads: LazyPagingItems<LaunchpadDto> = viewModel.launchpads.collectAsLazyPagingItems()

    PagingStateHandler<LaunchpadDto>(
        lazyType = LazyTypeEnum.LAZY_COLUMN,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = launchpads.loadState,
        itemCount = launchpads.itemCount
    ) {
        item { Text("LAUNCHPADS_CONTENT") }

        items(launchpads.itemCount) { index ->
            launchpads[index]?.let { launchpad ->
                Text(text = launchpad.name ?: "")
            }
        }
    }
}
