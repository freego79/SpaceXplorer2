package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.data.paging.DragonPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DragonRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getDragon(): Flow<PagingData<DragonDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.DRAGON_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { DragonPagingSource(api) }
        ).flow
    }
}
