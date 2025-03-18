package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.data.paging.LaunchpadPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchpadRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getLaunchpad(): Flow<PagingData<LaunchpadDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.LAUNCHPAD_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { LaunchpadPagingSource(api) }
        ).flow
    }
}
