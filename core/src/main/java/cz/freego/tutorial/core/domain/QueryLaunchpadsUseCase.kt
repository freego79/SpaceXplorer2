package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.data.repository.QueryLaunchpadsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryLaunchpadsUseCase @Inject constructor(
    private val repository: QueryLaunchpadsRepository
) {
    operator fun invoke(): Flow<PagingData<LaunchpadDto>> = repository.getLaunchpads()
}
