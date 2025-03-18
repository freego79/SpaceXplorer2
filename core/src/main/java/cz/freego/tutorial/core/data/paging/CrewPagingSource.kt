package cz.freego.tutorial.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.model.CrewQueryOptions
import cz.freego.tutorial.core.data.model.CrewQueryRequest
import javax.inject.Inject

class CrewPagingSource @Inject constructor(
    private val api: SpaceXApi
) : PagingSource<Int, CrewMemberDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CrewMemberDto> {
        return try {
            val page = params.key ?: 1
            val response = api.queryCrew(
                CrewQueryRequest(
                    options = CrewQueryOptions(
                        limit = Constants.CREW_PAGING_LIMIT,
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

    override fun getRefreshKey(state: PagingState<Int, CrewMemberDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
