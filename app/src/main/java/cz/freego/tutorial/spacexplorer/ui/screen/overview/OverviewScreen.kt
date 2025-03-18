package cz.freego.tutorial.spacexplorer.ui.screen.overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.LazyPagingItems
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.design.component.item.CrewSimpleItem
import cz.freego.tutorial.core.design.component.item.RocketProgressListItem
import cz.freego.tutorial.core.design.component.text.SubcategoryHeadlineText
import cz.freego.tutorial.core.presentation.OverviewViewModel
import cz.freego.tutorial.spacexplorer.ui.Screen

@Composable
fun OverviewScreen(
    navController: NavHostController,
    viewModel: OverviewViewModel = hiltViewModel()
) {
    val crewMembers: LazyPagingItems<CrewMemberDto> = viewModel.crewMembers.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        SubcategoryHeadlineText(text = "Členové posádek")

        LazyRow(
            modifier = Modifier.fillMaxWidth().height(120.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(crewMembers.itemCount) { index ->
                crewMembers[index]?.let { crewMember ->
                    CrewSimpleItem(crewMember = crewMember)
                }
            }
            crewMembers.apply {
                when {
                    loadState.append.endOfPaginationReached -> {
                        item {
                            Button(
                                modifier = Modifier.fillMaxHeight(),
                                onClick = {
                                    navController.navigate(Screen.SectionCrews.route)
                                },
                                shape = RoundedCornerShape(12.dp), // Zaoblené rohy
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Ikona šipky doprava
                                    contentDescription = "Next",
                                    tint = MaterialTheme.colorScheme.onPrimary // Barva ikony
                                )
                            }
                        }
                    }
                    loadState.refresh is androidx.paging.LoadState.Loading -> {
                        item {
                            RocketProgressListItem(modifier = Modifier.wrapContentSize())
                        }
                    }
                }
            }
        }
    }

}
