package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.data.repository.LaunchpadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLaunchpadUseCase @Inject constructor(
    private val repository: LaunchpadRepository
) {
    operator fun invoke(): Flow<PagingData<LaunchpadDto>> = repository.getLaunchpad()
}
