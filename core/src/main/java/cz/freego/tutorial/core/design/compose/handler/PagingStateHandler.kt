package cz.freego.tutorial.core.design.compose.handler

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import cz.freego.tutorial.core.design.compose.item.RocketProgressListItem

@Composable
fun <T : Any> PagingStateHandler(
    lazyType: String = "column", // "column" nebo "row" pro LazyColumn nebo LazyRow
    loadState: CombinedLoadStates,
    itemCount: Int,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    loadingItem: @Composable (() -> Unit) = { RocketProgressListItem() },
    errorItem: @Composable ((String) -> Unit) = { error -> Text(text = "Error: $error") },
    emptyItem: @Composable (() -> Unit) = { Text(text = "Žádná data") },
    endReachedItem: @Composable (() -> Unit) = { },
    content: LazyListScope.() -> Unit
) {
    if (lazyType == "column") {
        LazyColumn(
            modifier = modifier,
            contentPadding = contentPadding,
        ) {
            content() // Zde už máme LazyListScope, takže to bude fungovat správně

            when {
                loadState.refresh is LoadState.Loading -> {
                    item { loadingItem() }
                }
                loadState.append is LoadState.Loading -> {
                    item { loadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = loadState.refresh as LoadState.Error
                    item { errorItem(e.error.localizedMessage ?: "Neznámá chyba") }
                }
                loadState.append is LoadState.Error -> {
                    val e = loadState.append as LoadState.Error
                    item { errorItem(e.error.localizedMessage ?: "Neznámá chyba") }
                }
                loadState.append.endOfPaginationReached -> {
                    item { endReachedItem() }
                }
                itemCount == 0 -> {
                    item { emptyItem() }
                }
            }
        }
    } else {
        LazyRow(
            modifier = modifier,
            contentPadding = contentPadding,
        ) {
            content()

            when {
                loadState.refresh is LoadState.Loading -> {
                    item { loadingItem() }
                }
                loadState.append is LoadState.Loading -> {
                    item { loadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = loadState.refresh as LoadState.Error
                    item { errorItem(e.error.localizedMessage ?: "Neznámá chyba") }
                }
                loadState.append is LoadState.Error -> {
                    val e = loadState.append as LoadState.Error
                    item { errorItem(e.error.localizedMessage ?: "Neznámá chyba") }
                }
                loadState.append.endOfPaginationReached -> {
                    item { endReachedItem() }
                }
                itemCount == 0 -> {
                    item { emptyItem() }
                }
            }
        }
    }
}
