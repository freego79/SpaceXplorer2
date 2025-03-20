package cz.freego.tutorial.spacexplorer.ui.screen.section

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cz.freego.tutorial.spacexplorer.ui.Screen
import kotlin.math.max
import kotlin.math.min

@Deprecated("Testing Screen only - replace with real Screen")
@Composable
fun SectionScreen(navController: NavHostController, text: String, sectionId: Int) {

    val listState = rememberLazyListState()

    // toto zachytí procentuální visibility viditelných prvků pouze při recyklaci (jeden prvek mizí, nový se objevuje)
    /*
    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .collect { visibleItems ->
                visibleItems.forEach { item ->
                    val visiblePart = calculateVisibilityPercentage(item, listState)
                    Log.d("Visibility", "Item ${item.index} is $visiblePart% visible")
                }
            }
    }
    */

    // Toto zachytí i drobný posun a vždy vypíše procentuálně visibility viditelných prvků
    LaunchedEffect(listState) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo to listState.firstVisibleItemScrollOffset
        }.collect { (visibleItems, _) ->
            visibleItems.forEach { item ->
                val visibility = calculateVisibilityPercentage(item, listState)
                Log.d("Visibility", "Item ${item.index} is $visibility% visible")
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.Detail.createRoute(sectionId)) }) {
            Text("Otevřít Detail s ID: $sectionId")
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(state = listState) {
            items(50) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(if (index % 2 == 0) MaterialTheme.colorScheme.secondary
                        else MaterialTheme.colorScheme.tertiary)
                ) {
                    Text(
                        text = "Item $index",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

}

private fun calculateVisibilityPercentage(item: LazyListItemInfo, listState: LazyListState): Int {
    val itemStart = item.offset
    val itemEnd = item.offset + item.size

    val visibleStart = max(itemStart, listState.layoutInfo.viewportStartOffset)
    val visibleEnd = min(itemEnd, listState.layoutInfo.viewportEndOffset)
    val visibleHeight = max(0, visibleEnd - visibleStart)

    return (visibleHeight.toFloat() / item.size * 100).toInt()
}
