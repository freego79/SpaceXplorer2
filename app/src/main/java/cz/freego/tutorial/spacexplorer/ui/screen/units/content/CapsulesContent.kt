package cz.freego.tutorial.spacexplorer.ui.screen.units.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.design.compose.item.CapsuleListItem
import cz.freego.tutorial.core.presentation.CapsuleViewModel

@Composable
fun CapsulesContent(viewModel: CapsuleViewModel = hiltViewModel()) {
    val capsules: LazyPagingItems<CapsuleDto> = viewModel.capsules.collectAsLazyPagingItems()

    PagingStateHandler<CapsuleDto>(
        lazyType = LazyTypeEnum.LAZY_COLUMN,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = capsules.loadState,
        itemCount = capsules.itemCount
    ) {
        items(capsules.itemCount) { index ->
            capsules[index]?.let { capsule ->
                CapsuleListItem(capsule = capsule)
            }
        }
    }
}
