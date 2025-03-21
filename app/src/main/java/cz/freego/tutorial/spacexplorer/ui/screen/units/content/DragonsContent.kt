package cz.freego.tutorial.spacexplorer.ui.screen.units.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.design.compose.item.DragonListItem
import cz.freego.tutorial.core.presentation.DragonsViewModel

@Composable
fun DragonsContent(viewModel: DragonsViewModel = hiltViewModel()) {
    val dragons: LazyPagingItems<DragonDto> = viewModel.dragons.collectAsLazyPagingItems()

    PagingStateHandler<DragonDto>(
        lazyType = LazyTypeEnum.LAZY_COLUMN,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = dragons.loadState,
        itemCount = dragons.itemCount
    ) {
        items(dragons.itemCount) { index ->
            dragons[index]?.let { dragon ->
                DragonListItem(dragon = dragon)
            }
        }
    }
}
