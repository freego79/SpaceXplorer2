package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.repository.CrewRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCrewUseCase @Inject constructor(
    private val repository: CrewRepository
) {
    operator fun invoke(): Flow<PagingData<CrewMemberDto>> = repository.getCrew()
}
