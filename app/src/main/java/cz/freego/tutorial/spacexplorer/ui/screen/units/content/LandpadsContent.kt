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
import cz.freego.tutorial.core.data.model.LandpadDto
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.presentation.LandpadViewModel

@Composable
fun LandpadsContent(viewModel: LandpadViewModel = hiltViewModel()) {
    val landpads: LazyPagingItems<LandpadDto> = viewModel.landpads.collectAsLazyPagingItems()

    PagingStateHandler<LandpadDto>(
        lazyType = LazyTypeEnum.LAZY_COLUMN,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = landpads.loadState,
        itemCount = landpads.itemCount
    ) {
        item { Text("LANDPADS_CONTENT") }

        items(landpads.itemCount) { index ->
            landpads[index]?.let { landpad ->
                Text(text = landpad.name ?: "")
            }
        }
    }
}
