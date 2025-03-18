package cz.freego.tutorial.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.LandpadDto
import cz.freego.tutorial.core.data.model.LandpadQueryOptions
import cz.freego.tutorial.core.data.model.LandpadQueryRequest
import javax.inject.Inject

class LandpadPagingSource @Inject constructor(
    private val api: SpaceXApi
) : PagingSource<Int, LandpadDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LandpadDto> {
        return try {
            val page = params.key ?: 1
            val response = api.queryLandpads(
                LandpadQueryRequest(
                    options = LandpadQueryOptions(
                        limit = Constants.LANDPAD_PAGING_LIMIT,
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

    override fun getRefreshKey(state: PagingState<Int, LandpadDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
