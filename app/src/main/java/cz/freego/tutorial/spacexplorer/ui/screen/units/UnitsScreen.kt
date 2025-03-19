package cz.freego.tutorial.spacexplorer.ui.screen.units

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cz.freego.tutorial.spacexplorer.ui.screen.units.content.CapsulesContent
import cz.freego.tutorial.spacexplorer.ui.screen.units.content.DragonsContent
import cz.freego.tutorial.spacexplorer.ui.screen.units.content.LandpadsContent
import cz.freego.tutorial.spacexplorer.ui.screen.units.content.LaunchpadsContent
import cz.freego.tutorial.spacexplorer.ui.screen.units.content.RocketsContent
import cz.freego.tutorial.spacexplorer.ui.screen.units.content.ShipsContent
import kotlinx.coroutines.launch

@Composable
fun UnitsScreen(
    navController: NavHostController,
    categoryIndex: Int,
) {
    val tabItems = listOf(
        TabItem("Dragon", Icons.Default.Star),
        TabItem("Capsule", Icons.Default.Favorite),
        TabItem("Rakety", Icons.Default.Home),
        TabItem("Lodě", Icons.Default.Person),
        TabItem("Starty", Icons.Default.CheckCircle),
        TabItem("Přistání", Icons.Default.Settings)
    )

    val pagerState = rememberPagerState(initialPage = categoryIndex, pageCount = { tabItems.size })
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        // Custom Scrollable TabRow bez spodní čáry
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 8.dp,
            indicator = {}, // Odstraní defaultní podtržení
            divider = {}, // Odstranění dělící čáry
        ) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                                else MaterialTheme.colorScheme.surface
                            )
                            .width(96.dp)
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = tabItem.icon,
                            contentDescription = tabItem.title,
                            tint = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = tabItem.title,
                            fontSize = 12.sp,
                            color = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.secondary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }

        // Obsah obrazovek
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> DragonsContent()
                1 -> CapsulesContent()
                2 -> RocketsContent()
                3 -> ShipsContent()
                4 -> LaunchpadsContent()
                5 -> LandpadsContent()
            }
        }
    }
}

// Datová třída pro taby
private data class TabItem(val title: String, val icon: ImageVector)