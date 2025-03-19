package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.data.repository.QueryRocketsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryRocketsUseCase @Inject constructor(
    private val repository: QueryRocketsRepository
) {
    operator fun invoke(): Flow<PagingData<RocketDto>> = repository.getRockets()
}
