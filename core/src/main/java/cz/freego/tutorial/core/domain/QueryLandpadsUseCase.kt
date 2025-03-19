package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.LandpadDto
import cz.freego.tutorial.core.data.repository.QueryLandpadsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryLandpadsUseCase @Inject constructor(
    private val repository: QueryLandpadsRepository
) {
    operator fun invoke(): Flow<PagingData<LandpadDto>> = repository.getLandpads()
}
