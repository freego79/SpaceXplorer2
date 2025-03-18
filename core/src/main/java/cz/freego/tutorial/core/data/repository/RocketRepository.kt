package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.data.paging.RocketPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RocketRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getRocket(): Flow<PagingData<RocketDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.ROCKET_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { RocketPagingSource(api) }
        ).flow
    }
}
