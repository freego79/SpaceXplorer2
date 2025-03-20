package cz.freego.tutorial.wear.ui.screen.crew

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.presentation.CrewsViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import cz.freego.tutorial.core.design.theme.phone.ColorsDark
import cz.freego.tutorial.wear.design.compose.item.CrewWearListItem
import cz.freego.tutorial.wear.ui.Screen

@Composable
fun CrewsScreen(
    navController: NavHostController,
    viewModel: CrewsViewModel = hiltViewModel()
) {
    val crewMembers: LazyPagingItems<CrewMemberDto> = viewModel.crewMembers.collectAsLazyPagingItems()

    ScalingLazyColumn(
        modifier = Modifier.background(Color.Black).fillMaxSize()
    ) {
        item {
            Text(
                text = "Posádka",
                style = MaterialTheme.typography.titleLarge,
                color = ColorsDark.onSurface.copy(alpha = .75f),
            )
            Spacer(Modifier.height(16.dp))
        }

        items(crewMembers.itemCount) { index ->
            crewMembers[index]?.let { crewMember ->
                CrewWearListItem(
                    crewMember = crewMember,
                    onCrewClicked = {
                        crewMember.id?.let { id ->
                            navController.navigate(Screen.DetailCrew.createRoute(id))
                        }
                    }
                )
            }
        }
    }
}