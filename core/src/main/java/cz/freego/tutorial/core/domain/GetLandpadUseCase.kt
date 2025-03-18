package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.LandpadDto
import cz.freego.tutorial.core.data.repository.LandpadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLandpadUseCase @Inject constructor(
    private val repository: LandpadRepository
) {
    operator fun invoke(): Flow<PagingData<LandpadDto>> = repository.getLandpad()
}
