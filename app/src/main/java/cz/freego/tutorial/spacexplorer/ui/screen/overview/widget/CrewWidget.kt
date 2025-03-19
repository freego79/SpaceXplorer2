package cz.freego.tutorial.spacexplorer.ui.screen.overview.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.design.compose.button.GotoSpecialButton
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.design.compose.item.CrewSimpleItem
import cz.freego.tutorial.core.design.compose.item.RocketProgressListItem
import cz.freego.tutorial.core.design.compose.text.SubcategoryHeadlineText
import cz.freego.tutorial.spacexplorer.ui.Screen

@Composable
fun CrewWidget(
    crewMembers: LazyPagingItems<CrewMemberDto>,
    onGotoCrewScreenClicked: () -> Unit,
    navController: NavHostController,
    verticalPadding: Dp = 8.dp,
) {
    Spacer(Modifier.height(verticalPadding))

    SubcategoryHeadlineText(text = "Členové posádek")
    PagingStateHandler<CrewMemberDto>(
        lazyType = LazyTypeEnum.LAZY_ROW,
        modifier = Modifier.fillMaxWidth().height(152.dp),
        contentPadding = PaddingValues(8.dp),
        loadState = crewMembers.loadState,
        itemCount = crewMembers.itemCount,
        loadingItem = { RocketProgressListItem(modifier = Modifier.wrapContentSize()) },
        endReachedItem = {
            GotoSpecialButton(
                modifier = Modifier.fillMaxHeight(),
                onClick = { onGotoCrewScreenClicked() },
            )
        },
    ) {
        items(crewMembers.itemCount) { index ->
            crewMembers[index]?.let { crewMember ->
                CrewSimpleItem(
                    crewMember = crewMember,
                    onCrewClicked = { id ->
                        id?.let {
                            navController.navigate(Screen.DetailCrew.createRoute(id))
                        }
                    }
                )
            }
        }
    }

    Spacer(Modifier.height(verticalPadding))
}