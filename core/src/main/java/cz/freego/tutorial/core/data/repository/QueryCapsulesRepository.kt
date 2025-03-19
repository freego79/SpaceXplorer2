package cz.freego.tutorial.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.data.paging.CapsulePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QueryCapsulesRepository @Inject constructor(
    private val api: SpaceXApi
) {
    fun getCapsules(): Flow<PagingData<CapsuleDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.CAPSULE_PAGING_LIMIT,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { CapsulePagingSource(api) }
        ).flow
    }
}
