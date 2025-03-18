package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.data.paging.ShipPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShipRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getShip(): Flow<PagingData<ShipDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.SHIP_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { ShipPagingSource(api) }
        ).flow
    }
}
