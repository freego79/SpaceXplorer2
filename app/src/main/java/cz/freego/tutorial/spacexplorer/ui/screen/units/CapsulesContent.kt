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
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.presentation.CapsuleViewModel

@Composable
fun CapsulesContent(viewModel: CapsuleViewModel = hiltViewModel()) {
    val capsules: LazyPagingItems<CapsuleDto> = viewModel.capsules.collectAsLazyPagingItems()

    PagingStateHandler<CapsuleDto>(
        lazyType = "column",
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        loadState = capsules.loadState,
        itemCount = capsules.itemCount
    ) {
        item { Text("CAPSULES_CONTENT") }

        items(capsules.itemCount) { index ->
            capsules[index]?.let { capsule ->
                Text(text = "LAST UPDATES: ${capsule.lastUpdate ?: ""}")
            }
        }
    }
}
