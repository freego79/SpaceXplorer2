package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.data.repository.QueryDragonsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryDragonsUseCase @Inject constructor(
    private val repository: QueryDragonsRepository
) {
    operator fun invoke(): Flow<PagingData<DragonDto>> = repository.getDragons()
}
