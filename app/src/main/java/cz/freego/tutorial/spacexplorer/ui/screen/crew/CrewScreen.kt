package cz.freego.tutorial.spacexplorer.ui.screen.crew

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.LazyPagingItems
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.design.compose.item.CrewListItem
import cz.freego.tutorial.core.presentation.CrewViewModel

@Composable
fun CrewScreen(viewModel: CrewViewModel = hiltViewModel()) {
    val crewMembers: LazyPagingItems<CrewMemberDto> = viewModel.crewMembers.collectAsLazyPagingItems()

    PagingStateHandler<CrewMemberDto>(
        lazyType = LazyTypeEnum.LAZY_COLUMN,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = crewMembers.loadState,
        itemCount = crewMembers.itemCount
    ) {
        items(crewMembers.itemCount) { index ->
            crewMembers[index]?.let { crewMember ->
                CrewListItem(crewMember = crewMember)
            }
        }
    }
}
