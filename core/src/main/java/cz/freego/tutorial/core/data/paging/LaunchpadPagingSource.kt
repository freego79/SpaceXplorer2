package cz.freego.tutorial.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.data.model.LaunchpadQueryOptions
import cz.freego.tutorial.core.data.model.LaunchpadQueryRequest
import javax.inject.Inject

class LaunchpadPagingSource @Inject constructor(
    private val api: SpaceXApi
) : PagingSource<Int, LaunchpadDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LaunchpadDto> {
        return try {
            val page = params.key ?: 1
            val response = api.queryLaunchpads(
                LaunchpadQueryRequest(
                    options = LaunchpadQueryOptions(
                        limit = Constants.LAUNCHPAD_PAGING_LIMIT,
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

    override fun getRefreshKey(state: PagingState<Int, LaunchpadDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
