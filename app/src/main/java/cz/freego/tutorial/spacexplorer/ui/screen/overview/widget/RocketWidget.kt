package cz.freego.tutorial.spacexplorer.ui.screen.overview.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.design.compose.button.GotoSpecialButton
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.design.compose.item.RocketProgressListItem
import cz.freego.tutorial.core.design.compose.item.RocketSimpleItem
import cz.freego.tutorial.core.design.compose.text.SubcategoryHeadlineText

@Composable
fun RocketWidget(
    rockets: LazyPagingItems<RocketDto>,
    onGotoUnitsScreenRocketSectionClicked: () -> Unit,
    verticalPadding: Dp = 8.dp,
) {
    Spacer(Modifier.height(verticalPadding))

    SubcategoryHeadlineText(text = "Rakety")
    PagingStateHandler<RocketDto>(
        lazyType = LazyTypeEnum.LAZY_ROW,
        modifier = Modifier.fillMaxWidth().height(216.dp),
        contentPadding = PaddingValues(8.dp),
        loadState = rockets.loadState,
        itemCount = rockets.itemCount,
        loadingItem = { RocketProgressListItem(modifier = Modifier.fillMaxHeight()) },
        endReachedItem = {
            GotoSpecialButton(onClick = { onGotoUnitsScreenRocketSectionClicked() })
        },
    ) {
        items(rockets.itemCount) { index ->
            rockets[index]?.let { rocket ->
                RocketSimpleItem(rocket = rocket)
            }
        }
    }

    Spacer(Modifier.height(verticalPadding))
}