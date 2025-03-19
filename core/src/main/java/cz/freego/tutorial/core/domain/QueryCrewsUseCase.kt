package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.repository.QueryCrewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryCrewsUseCase @Inject constructor(
    private val repository: QueryCrewsRepository
) {
    operator fun invoke(): Flow<PagingData<CrewMemberDto>> = repository.getCrews()
}
