package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.paging.CrewPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QueryCrewsRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getCrews(): Flow<PagingData<CrewMemberDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.CREW_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { CrewPagingSource(api) }
        ).flow
    }
}
