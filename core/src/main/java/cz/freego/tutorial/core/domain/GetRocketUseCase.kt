package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.data.repository.RocketRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRocketUseCase @Inject constructor(
    private val repository: RocketRepository
) {
    operator fun invoke(): Flow<PagingData<RocketDto>> = repository.getRocket()
}
