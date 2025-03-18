package cz.freego.tutorial.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.data.model.RocketQueryOptions
import cz.freego.tutorial.core.data.model.RocketQueryRequest
import javax.inject.Inject

class RocketPagingSource @Inject constructor(
    private val api: SpaceXApi
) : PagingSource<Int, RocketDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RocketDto> {
        return try {
            val page = params.key ?: 1
            val response = api.queryRocket(
                RocketQueryRequest(
                    options = RocketQueryOptions(
                        limit = Constants.ROCKET_PAGING_LIMIT,
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

    override fun getRefreshKey(state: PagingState<Int, RocketDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
