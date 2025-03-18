package cz.freego.tutorial.spacexplorer.ui.screen.overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.LazyPagingItems
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.presentation.OverviewViewModel
import cz.freego.tutorial.spacexplorer.ui.Screen
import cz.freego.tutorial.spacexplorer.ui.screen.overview.widget.CrewWidget
import cz.freego.tutorial.spacexplorer.ui.screen.overview.widget.RocketWidget

@Composable
fun OverviewScreen(
    navController: NavHostController,
    viewModel: OverviewViewModel = hiltViewModel()
) {
    val crewMembers: LazyPagingItems<CrewMemberDto> = viewModel.crewMembers.collectAsLazyPagingItems()
    val rockets: LazyPagingItems<RocketDto> = viewModel.rockets.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            CrewWidget(
                crewMembers = crewMembers,
                onGotoCrewScreenClicked = { navController.navigate(Screen.SectionCrews.route) },
            )
        }
        item {
            RocketWidget(
                rockets = rockets,
                onGotoUnitsScreenRocketSectionClicked = {},
            )
        }
    }
}
