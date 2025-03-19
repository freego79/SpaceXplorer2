package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.data.repository.QueryCapsulesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryCapsulesUseCase @Inject constructor(
    private val repository: QueryCapsulesRepository
) {
    operator fun invoke(): Flow<PagingData<CapsuleDto>> = repository.getCapsules()
}
