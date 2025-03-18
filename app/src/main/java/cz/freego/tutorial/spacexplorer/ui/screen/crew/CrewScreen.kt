package cz.freego.tutorial.spacexplorer.ui.screen.crew

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.LazyPagingItems
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.design.component.item.CrewListItem
import cz.freego.tutorial.core.design.component.item.RocketProgressListItem
import cz.freego.tutorial.core.presentation.CrewViewModel

@Composable
fun CrewScreen(viewModel: CrewViewModel = hiltViewModel()) {
    val crewMembers: LazyPagingItems<CrewMemberDto> = viewModel.crewMembers.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(crewMembers.itemCount) { index ->
            crewMembers[index]?.let { crewMember ->
                CrewListItem(crewMember = crewMember)
            }
        }

        crewMembers.apply {
            when {
                loadState.append.endOfPaginationReached -> {
                    //item { Text("No more data") }
                }
                loadState.refresh is androidx.paging.LoadState.Loading -> {
                    //item { CircularProgressIndicator() }
                    item {
                        RocketProgressListItem()
                    }
                }
            }
        }
    }
}
