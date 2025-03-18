package cz.freego.tutorial.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.data.model.ShipQueryOptions
import cz.freego.tutorial.core.data.model.ShipQueryRequest
import javax.inject.Inject

class ShipPagingSource @Inject constructor(
    private val api: SpaceXApi
) : PagingSource<Int, ShipDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShipDto> {
        return try {
            val page = params.key ?: 1
            val response = api.queryShips(
                ShipQueryRequest(
                    options = ShipQueryOptions(
                        limit = Constants.SHIP_PAGING_LIMIT,
                        page = page,
                    )
                )
            )

            LoadResult.Page(
                data = response.docs,
                prevKey = if (response.hasPrevPage) page - 1 else null,
                nextKey = if (response.hasNextPage) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ShipDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
