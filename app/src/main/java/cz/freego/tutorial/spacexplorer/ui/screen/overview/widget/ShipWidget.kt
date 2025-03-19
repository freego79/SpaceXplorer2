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
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.design.compose.button.GotoSpecialButton
import cz.freego.tutorial.core.design.compose.handler.LazyTypeEnum
import cz.freego.tutorial.core.design.compose.handler.PagingStateHandler
import cz.freego.tutorial.core.design.compose.item.RocketProgressListItem
import cz.freego.tutorial.core.design.compose.item.ShipSimpleItem
import cz.freego.tutorial.core.design.compose.text.SubcategoryHeadlineText

@Composable
fun ShipWidget(
    ships: LazyPagingItems<ShipDto>,
    onGotoUnitsScreenShipSectionClicked: () -> Unit,
    verticalPadding: Dp = 8.dp,
) {
    Spacer(Modifier.height(verticalPadding))

    SubcategoryHeadlineText(text = "Lodě")
    PagingStateHandler<ShipDto>(
        lazyType = LazyTypeEnum.LAZY_ROW,
        modifier = Modifier.fillMaxWidth().height(216.dp),
        contentPadding = PaddingValues(8.dp),
        loadState = ships.loadState,
        itemCount = ships.itemCount,
        loadingItem = { RocketProgressListItem(modifier = Modifier.fillMaxHeight()) },
        endReachedItem = {
            GotoSpecialButton(onClick = { onGotoUnitsScreenShipSectionClicked() })
        },
    ) {
        items(ships.itemCount) { index ->
            ships[index]?.let { ship ->
                ShipSimpleItem(ship = ship)
            }
        }
    }

    Spacer(Modifier.height(verticalPadding))
}