package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.LandpadDto
import cz.freego.tutorial.core.data.paging.LandpadPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QueryLandpadsRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getLandpads(): Flow<PagingData<LandpadDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.LANDPAD_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { LandpadPagingSource(api) }
        ).flow
    }
}
