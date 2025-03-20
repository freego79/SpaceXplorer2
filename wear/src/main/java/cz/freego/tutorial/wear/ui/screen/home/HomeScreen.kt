package cz.freego.tutorial.wear.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import cz.freego.tutorial.wear.ui.screen.crew.CrewsScreen
import cz.freego.tutorial.wear.ui.screen.rocket.RocketsScreen

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 2 },
    )

    HorizontalPager(
        modifier = Modifier.background(Color.Black).fillMaxSize(),
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> CrewsScreen(navController = navController)
            1 -> RocketsScreen(navController = navController)
        }
    }
}
